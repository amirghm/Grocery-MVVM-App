package com.amirghm.gerocery.data.repository

import com.amirghm.gerocery.data.model.responses.CatalogResponseModel
import com.amirghm.gerocery.data.source.remote.CatalogRemoteDataSource
import kotlinx.coroutines.flow.Flow

class CatalogRepository(remoteCatalogDataSource: CatalogRemoteDataSource) {
    suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
    {
        TODO("Not yet implemented")
    }
}