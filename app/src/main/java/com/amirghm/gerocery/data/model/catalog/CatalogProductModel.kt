package com.amirghm.gerocery.data.model.catalog

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Holds product data and used into the catalog adapter
 * @param id : product id
 * @param name : product name
 * @param imageUrl : product image short url
 * @param description : product description
 * @param amount : product price
 * @param currency : product price currency
 */
@Parcelize
data class CatalogProductModel(
    val id: String,
    val name: String,
    val imageUrl: String,
    val description: String,
    val amount: String,
    val currency: String
) : CatalogModel(), Parcelable {

    fun getAmountWithCurrency():String
    {
        return "$amount $currency"
    }
}
