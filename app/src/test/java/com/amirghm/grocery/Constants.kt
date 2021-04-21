package com.amirghm.grocery

import com.amirghm.grocery.data.model.catalog.CatalogProductModel
import com.amirghm.grocery.data.model.responses.CatalogResponseModel
import com.amirghm.grocery.data.model.responses.ProductResponseModel
import com.amirghm.grocery.data.model.responses.SalePriceResponseModel


internal object Constants {
    const val CATALOG_API = "http://mobcategories.s3-website-eu-west-1.amazonaws.com/"

    private val FAKE_CATALOG_NETWORK_MODEL = CatalogResponseModel(
        id = "id",
        name = "title",
        description = "description",
        products = mutableListOf<ProductResponseModel>().apply {
            add(
                ProductResponseModel(
                    "1240",
                    "id",
                    "egg",
                    FAKE_IMAGE_URL,
                    "no description",
                    SalePriceResponseModel("123", "Euro")
                )
            )
        }
    )
    val FAKE_CATALOG_MODEL = CatalogProductModel("422","Milk","/Milk.jpg","Very Good","6.25","EUR")
    val FAKE_RESPONSE_MODEL = listOf(FAKE_CATALOG_NETWORK_MODEL)
    val FAKE_EMPTY_MODEL:List<CatalogResponseModel>  = listOf()
    const val FAKE_IMAGE_URL = "/url.png"
}