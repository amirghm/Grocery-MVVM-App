package com.amirghm.grocery.data.repository

import com.amirghm.grocery.data.model.responses.CatalogResponseModel
import com.amirghm.grocery.utils.helper.network.Result
import kotlinx.coroutines.flow.Flow

interface CatalogRepository {
    suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
}