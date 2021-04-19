package com.amirghm.mobiquitysample.data.source

import com.amirghm.mobiquitysample.data.model.responses.CatalogResponseModel
import com.amirghm.mobiquitysample.utils.helper.network.Result
import kotlinx.coroutines.flow.Flow

interface DataSource {
    suspend fun getProducts(): Flow<Result<List<CatalogResponseModel>?>>
}