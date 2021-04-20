package com.amirghm.gerocery.ui.catalog.list

import androidx.recyclerview.widget.DiffUtil
import com.amirghm.gerocery.data.model.catalog.CatalogHeaderModel
import com.amirghm.gerocery.data.model.catalog.CatalogModel
import com.amirghm.gerocery.data.model.catalog.CatalogProductModel

class CatalogDiffUtilCallback(private val oldList:List<CatalogModel>, private val newList:List<CatalogModel>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return  newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[oldItemPosition]

        if (oldItem is CatalogProductModel && newItem is CatalogProductModel) {
            return oldItem.id == newItem.id
        } else if (oldItem is CatalogHeaderModel && newItem is CatalogHeaderModel) {
            return oldItem.id == newItem.id
        }

        return false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[oldItemPosition]

        if (oldItem is CatalogProductModel && newItem is CatalogProductModel) {
            return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
        } else if (oldItem is CatalogHeaderModel && newItem is CatalogHeaderModel) {
            return oldItem.id == newItem.id && oldItem.name == newItem.name
        }

        return false

    }

}