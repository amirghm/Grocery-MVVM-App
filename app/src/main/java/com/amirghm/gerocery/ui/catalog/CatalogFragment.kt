package com.amirghm.gerocery.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.amirghm.gerocery.R
import com.amirghm.gerocery.data.model.catalog.CatalogHeaderModel
import com.amirghm.gerocery.databinding.FragmentCatalogBinding
import com.amirghm.gerocery.ui.catalog.list.CatalogAdapter
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

        setupRecyclerView()

        binding.swipeToRefresh.setOnRefreshListener {
            //TODO("Not yet implemented")
        }
    }

    private fun configureViewModel()
    {
        viewModel.catalogList.observe(viewLifecycleOwner,{
            adapter.updateData(it!!)
        })
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