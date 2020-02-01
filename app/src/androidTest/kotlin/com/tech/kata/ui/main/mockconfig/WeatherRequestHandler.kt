package com.tech.kata.ui.main.mockconfig

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class WeatherRequestHandler : RecordedRequestHandler() {

    override fun canHandleRequest(request: RecordedRequest): Boolean {
        return request.method == "GET" && request.path.contains(WEATHER_LONDON)
    }

    override fun getResponse(request: RecordedRequest): MockResponse {
        val body = readJsonFile("weather/get.json")
        return getResponseWithBody(200, body)
    }

    companion object {

        private val WEATHER_LONDON = "/weather?q=London"
    }
}
