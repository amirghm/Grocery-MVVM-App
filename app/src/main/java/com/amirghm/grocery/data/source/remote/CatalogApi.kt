package com.amirghm.grocery.data.source.remote

import com.amirghm.grocery.data.model.responses.CatalogResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface CatalogApi {
    @GET(".")
    suspend fun getProducts(): Response<List<CatalogResponseModel>>
}