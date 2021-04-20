package com.amirghm.gerocery.data.repository

import com.amirghm.gerocery.data.model.responses.CatalogResponseModel
import com.amirghm.gerocery.utils.helper.network.Result
import kotlinx.coroutines.flow.Flow

interface CatalogRepository {
    suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
}