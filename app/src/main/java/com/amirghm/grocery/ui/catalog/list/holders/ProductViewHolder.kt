package com.amirghm.grocery.ui.catalog.list.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.amirghm.grocery.data.model.catalog.CatalogProductModel
import com.amirghm.grocery.databinding.ItemProductBinding
import com.amirghm.grocery.ui.catalog.CatalogFragmentDirections

class ProductViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CatalogProductModel) {
        binding.item = item
        binding.setClickListener { onProductClicked(it, item) }
    }

    private fun onProductClicked(view: View?, item: CatalogProductModel) {
        val action =
            CatalogFragmentDirections.actionCatalogFragmentToProductDetailsFragment(item)
        view?.findNavController()?.navigate(action)
    }

    companion object {
        fun create(parent: ViewGroup) = ProductViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}