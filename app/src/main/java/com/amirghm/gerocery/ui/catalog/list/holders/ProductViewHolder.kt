package com.amirghm.gerocery.ui.catalog.list.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amirghm.gerocery.data.model.catalog.CatalogProductModel
import com.amirghm.gerocery.databinding.ItemProductBinding

class ProductViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CatalogProductModel) {
        binding.item = item
        binding.setClickListener { onProductClicked(it, item) }
    }

    private fun onProductClicked(view: View?, item: CatalogProductModel) {
      //  TODO("To Be Implemented")
    }

    companion object {
        fun create(parent: ViewGroup) = ProductViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}