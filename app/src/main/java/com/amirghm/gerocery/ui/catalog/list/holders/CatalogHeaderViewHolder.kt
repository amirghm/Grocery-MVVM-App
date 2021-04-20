package com.amirghm.gerocery.ui.catalog.list.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amirghm.gerocery.data.model.catalog.CatalogHeaderModel
import com.amirghm.gerocery.databinding.ItemHeaderBinding

class CatalogHeaderViewHolder(private val binding: ItemHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CatalogHeaderModel) {
        binding.item = item
    }

    companion object {
        fun create(parent: ViewGroup) = CatalogHeaderViewHolder(
            ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}