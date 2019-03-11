package com.tech.kata.ui.main.mockconfig

import android.os.Handler
import androidx.test.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockResponseDispatcher internal constructor() : Dispatcher() {

    private val airportHandler = AirportsRecordedRequestHandler()

    override fun dispatch(request: RecordedRequest): MockResponse {

        if (airportHandler.canHandleRequest(request)) {
            return airportHandler.getResponse(request)
        }

        return throwUnsupportedException("Could not handle", request.getPath())
    }

    private fun throwUnsupportedException(message: String, path: String): MockResponse {
        val mainThreadHandler = Handler(
            InstrumentationRegistry.getTargetContext().getMainLooper()
        )
        mainThreadHandler.post { throw UnsupportedOperationException("$message $path") }

        throw UnsupportedOperationException()
    }

    companion object {

        private val X_MSL_CLIENT = "X-MSL-Client"
        private val X_MSL_UID = "X-MSL-UID"
        private val ACCEPT_TYPE = "Accept"
        private val MSL_V1_JSON = "application/vnd.msl.v1+json"
        private val MSL_V2_JSON = "application/vnd.msl.v2+json"
        private val MSL_V3_JSON = "application/vnd.msl.v3+json"
        private val MSL_V4_JSON = "application/vnd.msl.v4+json"
        private val MSL_V5_JSON = "application/vnd.msl.v5+json"
        private val BAD_REQUEST = 400
    }
}
