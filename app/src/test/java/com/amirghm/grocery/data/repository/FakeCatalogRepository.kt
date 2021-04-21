package com.amirghm.grocery.data.repository

import com.amirghm.grocery.Constants.FAKE_EMPTY_MODEL
import com.amirghm.grocery.data.model.responses.CatalogResponseModel
import com.amirghm.grocery.Constants.FAKE_RESPONSE_MODEL
import com.amirghm.grocery.utils.helper.network.ErrorModel
import com.amirghm.grocery.utils.helper.network.ErrorStatus
import com.amirghm.grocery.utils.helper.network.Result
import kotlinx.coroutines.flow.flow

class FakeCatalogRepository : CatalogRepository {
    private var errorCode = 200
    private var errorMessage = "Not Found"
    private var shouldReturnError = false
    private var shouldEmptyModel = false

    fun setReturnCode(code:Int)
    {
        errorCode = code
    }

    fun setErrorMessage(error:String) {
        errorMessage = error
    }

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
        if(shouldReturnError)
            errorCode = 404
    }

    fun sendEmptyModel(value: Boolean)
    {
        shouldEmptyModel = value
    }

    override suspend fun getProducts() = flow {
        if (shouldReturnError) {
            emit(Result.error<List<CatalogResponseModel>>(ErrorModel(errorMessage, errorCode, ErrorStatus.INVALID_PARAMETERS)))
        } else {
            emit(Result.success(if(shouldEmptyModel) FAKE_EMPTY_MODEL else FAKE_RESPONSE_MODEL))
        }
    }
}