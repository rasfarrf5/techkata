package com.tech.kata.weather

import io.reactivex.Observable
import javax.inject.Inject

class WeatherProvider @Inject constructor(
    private val weatherService: WeatherService
) {

    fun getWeather(): Observable<WeatherResult> {
        return weatherService.getWeatherDetails()
            .map { response -> WeatherResult.Success(response.main.temp) as WeatherResult }
            .onErrorReturn { WeatherResult.Failed() }
    }
}