package com.amirghm.grocery.data.model.catalog

/**
 * Holds header data and used into the catalog adapter
 * @param id : header category id
 * @param name : header category name
 */
data class CatalogHeaderModel(val id: String, val name: String) : CatalogModel()