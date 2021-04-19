package com.amirghm.gerocery.data.source.remote

import com.amirghm.gerocery.data.model.responses.CatalogResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface CatalogApi {
    // TODO: Add GetProducts Address here
    @GET("")
    suspend fun getProducts(): Response<List<CatalogResponseModel>>
}