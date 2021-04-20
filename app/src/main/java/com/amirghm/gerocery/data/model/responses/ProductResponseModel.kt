package com.amirghm.gerocery.data.model.responses

/**
 * Usage: Response Model for storing product which fetched from the server
 * @param id : the product id
 * @param categoryId : product category id
 * @param name : product name
 * @param url : image short url (should be concat with the base image url
 * @param description : description about the product
 * @param salePrice : the price of product
 */
data class ProductResponseModel(
    val id: String,
    val categoryId: String,
    val name: String,
    val url: String,
    val description: String,
    val salePrice: SalePriceResponseModel
)