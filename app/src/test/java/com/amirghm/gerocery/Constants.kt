package com.amirghm.gerocery

import com.amirghm.gerocery.data.model.catalog.CatalogHeaderModel
import com.amirghm.gerocery.data.model.catalog.CatalogProductModel

internal object Constants {
    val CATALOG_API = "http://mobcategories.s3-website-eu-west-1.amazonaws.com/"

    val MOCK_DATA = arrayListOf(
            CatalogHeaderModel("123","Food"),
            CatalogProductModel("42","Bread","/Bread.jpg","Very Good","0.5","EUR"),
            CatalogProductModel("422","Milk","/Milk.jpg","Very Good","6.25","EUR"),
            CatalogProductModel("1","Sandwich","/Sandwich.jpg","Very Good","10","EUR"),
            CatalogProductModel("4412","Cake","/Cake.jpg","Very Good","4.0","EUR"),
            CatalogHeaderModel("123","Drink"),
            CatalogProductModel("4412","Juice","/Juice.jpg","Very Good","0.20","EUR"),
            CatalogProductModel("1","Fanta","/Fanta.jpg","Very Good","10","EUR"),
            CatalogProductModel("4412","Beer","/Beer.jpg","Very Good","1.0","EUR"),
            CatalogProductModel("422","Cola","/Cola.jpg","Very Good","2.45","EUR"),
        )
}