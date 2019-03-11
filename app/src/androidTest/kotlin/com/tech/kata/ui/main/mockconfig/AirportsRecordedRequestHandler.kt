package com.tech.kata.ui.main.mockconfig

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class AirportsRecordedRequestHandler : RecordedRequestHandler() {

    override fun canHandleRequest(request: RecordedRequest): Boolean {
        return request.method == "GET" && request.path.contains(AIRPORTS_DESTINATION_SIN)
    }

    override fun getResponse(request: RecordedRequest): MockResponse {
        val body = readJsonFile("airports/get.json")
        return getResponseWithBody(200, body)
    }

    companion object {

        private val AIRPORTS_DESTINATION_SIN = "/airports"
    }
}
