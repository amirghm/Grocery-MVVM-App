package com.amirghm.gerocery.data.source.remote

import com.amirghm.gerocery.data.source.CatalogDataSource
import com.amirghm.gerocery.utils.helper.network.ResponseHelper
import javax.inject.Inject

class CatalogRemoteDataSourceImpl @Inject constructor(var catalogApi: CatalogApi) : CatalogDataSource, ResponseHelper() {
    override suspend fun getProducts() = getResultAsFlow { catalogApi.getProducts() }
}