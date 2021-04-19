package com.amirghm.gerocery.data.source

import com.amirghm.gerocery.data.model.responses.CatalogResponseModel
import com.amirghm.gerocery.utils.helper.network.Result
import kotlinx.coroutines.flow.Flow

interface CatalogDataSource {
    suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
}