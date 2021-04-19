package com.amirghm.mobiquitysample.data.repository

import com.amirghm.mobiquitysample.data.model.responses.CatalogResponseModel
import com.amirghm.mobiquitysample.data.source.remote.CatalogDataSource
import com.amirghm.mobiquitysample.di.RepositoryModule
import kotlinx.coroutines.flow.Flow

class CatalogRepository(remoteCatalogDataSource: CatalogDataSource) {
    suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
    {
        // TODO: Must Be Implemented
    }
}