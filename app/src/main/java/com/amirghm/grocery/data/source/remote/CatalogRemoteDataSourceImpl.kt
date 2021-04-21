package com.amirghm.grocery.data.source.remote

import com.amirghm.grocery.data.source.CatalogDataSource
import com.amirghm.grocery.utils.helper.network.ResponseHelper
import javax.inject.Inject

class CatalogRemoteDataSourceImpl @Inject constructor(var catalogApi: CatalogApi) : CatalogDataSource, ResponseHelper() {
    override suspend fun getProducts() = getResultAsFlow { catalogApi.getProducts() }
}