package com.amirghm.mobiquitysample.data.source.remote

import com.amirghm.mobiquitysample.data.model.responses.CatalogResponseModel
import com.amirghm.mobiquitysample.data.source.DataSource
import com.amirghm.mobiquitysample.utils.helper.network.Result
import kotlinx.coroutines.flow.Flow

class CatalogDataSource(catalogApi: CatalogApi) : DataSource {
    override suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
    {
        // TODO: Must Be Implemented
    }
}