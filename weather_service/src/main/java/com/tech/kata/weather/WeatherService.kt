package com.tech.kata.weather

import io.reactivex.Observable
import retrofit2.http.GET

interface WeatherService {

    @GET("weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
    fun getWeatherDetails(): Observable<WeatherResponse>
}