package com.amirghm.gerocery.data.source.remote

import com.amirghm.gerocery.data.model.responses.CatalogResponseModel
import com.amirghm.gerocery.data.source.CatalogDataSource
import com.amirghm.gerocery.utils.helper.network.Result
import kotlinx.coroutines.flow.Flow

class CatalogRemoteDataSource(catalogApi: CatalogApi) : CatalogDataSource {
    override suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
    {
        TODO("Not yet implemented")
    }
}