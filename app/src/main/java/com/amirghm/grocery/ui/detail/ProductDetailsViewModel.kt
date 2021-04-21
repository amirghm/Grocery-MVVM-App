package com.amirghm.grocery.ui.detail

import androidx.lifecycle.ViewModel
import com.amirghm.grocery.data.model.catalog.CatalogProductModel

class ProductDetailsViewModel : ViewModel() {
    lateinit var productModel: CatalogProductModel
}