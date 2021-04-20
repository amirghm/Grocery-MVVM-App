package com.amirghm.gerocery.data.model.responses

/**
 * Usage: Response Model for storing data fetched from the server
 * @param id : the category id
 * @param name : category name
 * @param description : description about the category
 * @param products : list of products
 */
data class CatalogResponseModel(
    val id: String,
    val name: String,
    val description: String,
    val products: List<ProductResponseModel>
)



