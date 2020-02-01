package com.tech.kata.ui.main.mockconfig

import android.os.Handler
import androidx.test.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockResponseDispatcher internal constructor() : Dispatcher() {

    private val airportHandler = AirportsRecordedRequestHandler()
    private val weatherHandler = WeatherRequestHandler()

    override fun dispatch(request: RecordedRequest): MockResponse {

        return if (airportHandler.canHandleRequest(request)) {
            airportHandler.getResponse(request)
        } else if (weatherHandler.canHandleRequest(request)) {
            weatherHandler.getResponse(request)
        } else {
            throwUnsupportedException("Could not handle", request.getPath())
        }
    }

    private fun throwUnsupportedException(message: String, path: String): MockResponse {
        val mainThreadHandler = Handler(
            InstrumentationRegistry.getTargetContext().getMainLooper()
        )
        mainThreadHandler.post { throw UnsupportedOperationException("$message $path") }

        throw UnsupportedOperationException()
    }
}
