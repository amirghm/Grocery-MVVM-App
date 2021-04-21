package com.amirghm.grocery.ui.catalog.mapper

import com.amirghm.grocery.BuildConfig
import com.amirghm.grocery.data.model.catalog.CatalogHeaderModel
import com.amirghm.grocery.data.model.catalog.CatalogModel
import com.amirghm.grocery.data.model.catalog.CatalogProductModel
import com.amirghm.grocery.data.model.responses.CatalogResponseModel
import com.amirghm.grocery.data.model.responses.ProductResponseModel


/**
 * function for CatalogViewModel to convert network response to presentation suitable model
 * */
fun mapCatalogResponseToUIList(responseList: List<CatalogResponseModel>?): List<CatalogModel> {
    if (responseList.isNullOrEmpty()) {
        return emptyList()
    }

    val catalogModelList = mutableListOf<CatalogModel>()
    for (catalog in responseList) {
        catalogModelList.add(catalog.toCatalogHeaderModel())
        for (product in catalog.products) {
            catalogModelList.add(product.toCatalogProductModel())
        }
    }

    return catalogModelList
}

private fun ProductResponseModel.toCatalogProductModel() =
    CatalogProductModel(
        this.id,
        this.name,
        getImageUrl(this.url),
        this.description,
        this.salePrice.amount,
        this.salePrice.currency
    )

private fun CatalogResponseModel.toCatalogHeaderModel() =
    CatalogHeaderModel(this.id, this.name)

fun getImageUrl(url: String) = "${BuildConfig.BASE_IMAGE_URL}$url"