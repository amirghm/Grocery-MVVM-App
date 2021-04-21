package com.amirghm.grocery.data.repository

import com.amirghm.grocery.data.source.CatalogDataSource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

open class CatalogRepositoryImpl constructor(private val catalogDataSource: CatalogDataSource):CatalogRepository {
    override suspend fun getProducts() = catalogDataSource.getProducts().map {
        // The Business Logic can be added here
        it
    }
}