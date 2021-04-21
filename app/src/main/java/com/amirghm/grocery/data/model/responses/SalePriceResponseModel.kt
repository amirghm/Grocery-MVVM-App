package com.amirghm.grocery.data.model.responses

/**
 * Usage: Response Model for storing product sale price which fetched from the server
 * @param amount : the product sale amount
 * @param currency : product price currency
 */
data class SalePriceResponseModel(val amount: String, val currency: String)