package com.amirghm.grocery.data.source

import com.amirghm.grocery.data.model.responses.CatalogResponseModel
import com.amirghm.grocery.utils.helper.network.Result
import kotlinx.coroutines.flow.Flow

interface CatalogDataSource {
    suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
}