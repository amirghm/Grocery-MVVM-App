package com.amirghm.gerocery.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.amirghm.gerocery.R
import com.amirghm.gerocery.databinding.FragmentProductDetailsBinding

/**
 * This fragment is responsible for showing products details
 */
class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel by viewModels<ProductDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    private fun readArguments() {
        val args: ProductDetailsFragmentArgs by navArgs()
        viewModel.productModel = args.product
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readArguments()
        configureViews()
    }

    private fun configureViews() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.product = viewModel.productModel

        binding.addToBasketButton.setOnClickListener { onAddToBasketButtonClicked() }
    }

    private fun onAddToBasketButtonClicked() {
        Toast.makeText(activity, R.string.product_details__message_added_to_basket,Toast.LENGTH_LONG).show()
    }
}