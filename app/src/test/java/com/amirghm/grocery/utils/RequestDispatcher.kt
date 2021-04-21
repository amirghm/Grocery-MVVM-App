package com.amirghm.grocery.utils

import com.amirghm.grocery.Constants.CATALOG_API
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

/**
 * Handles Requests from mock web server
 */
internal class RequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            CATALOG_API -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("json/catalog_list_response.json"))
            }

            else -> throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }
}