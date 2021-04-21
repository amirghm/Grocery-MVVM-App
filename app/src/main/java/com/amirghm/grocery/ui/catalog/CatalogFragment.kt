package com.amirghm.grocery.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.amirghm.grocery.R
import com.amirghm.grocery.data.model.catalog.CatalogHeaderModel
import com.amirghm.grocery.data.model.catalog.CatalogModel
import com.amirghm.grocery.databinding.FragmentCatalogBinding
import com.amirghm.grocery.ui.catalog.list.CatalogAdapter
import com.amirghm.grocery.utils.extentions.observeOnce
import com.amirghm.grocery.utils.helper.network.ErrorModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : Fragment() {

    private lateinit var adapter: CatalogAdapter
    private lateinit var binding: FragmentCatalogBinding
    private val viewModel by viewModels<CatalogViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureViews()
        configureViewModel()
    }

    private fun configureViews() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.swipeToRefresh.setColorSchemeResources(R.color.colorAccent)

        setupRecyclerView()

        binding.swipeToRefresh.setOnRefreshListener { viewModel.refreshList() }
        binding.noInternetContainer.noInternetTryAgainButton.setOnClickListener { viewModel.refreshList() }
        binding.emptyStateContainer.emptyStateTryAgainButton.setOnClickListener { viewModel.refreshList() }
    }

    private fun configureViewModel()
    {
        viewModel.catalogList.observe(viewLifecycleOwner,{ handleCatalogData(it) })
        viewModel.errorModel.observeOnce { showError(it) }
    }

    private fun handleCatalogData(catalogs: List<CatalogModel>) {
        if(catalogs.isEmpty()) {
            showEmptyState()
            hideError()
        }
        else {
            hideEmptyState()
            hideError()
            adapter.updateData(catalogs)
        }
    }

    private fun showEmptyState() {
        binding.emptyStateContainer.root.visibility = View.VISIBLE
    }

    private fun hideEmptyState()
    {
        binding.emptyStateContainer.root.visibility = View.GONE
    }

    private fun showError(errorModel: ErrorModel?) {
        if(errorModel!=null)
            binding.noInternetContainer.root.visibility = View.VISIBLE
    }

    private fun hideError()
    {
        binding.noInternetContainer.root.visibility = View.GONE
    }

    private fun setupRecyclerView() {
        binding.productsRecyclerView.adapter = getAdapter()
        binding.productsRecyclerView.layoutManager = getLayoutManager()
    }
    private fun getLayoutManager(): GridLayoutManager {
        val layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.product_span_size))
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (viewModel.catalogList.value?.get(position) is CatalogHeaderModel) {
                    return resources.getInteger(R.integer.product_span_size)
                }
                return 1
            }
        }

        return layoutManager
    }

    private fun getAdapter(): CatalogAdapter {
        adapter = CatalogAdapter()
        return adapter
    }

}