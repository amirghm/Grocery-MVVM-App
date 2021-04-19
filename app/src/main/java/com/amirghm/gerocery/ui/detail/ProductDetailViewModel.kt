package com.amirghm.gerocery.ui.detail

import androidx.lifecycle.ViewModel
import com.amirghm.gerocery.data.model.catalog.CatalogProductModel

class ProductDetailViewModel : ViewModel() {
    lateinit var productModel: CatalogProductModel
}