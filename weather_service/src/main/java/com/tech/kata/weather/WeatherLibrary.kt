package com.tech.kata.weather

import retrofit2.Retrofit

class WeatherLibrary(val retrofit: Retrofit) {

    val component = DaggerWeatherComponent.builder()
        .weatherModule(WeatherModule(retrofit))
        .build()

    fun weatherProvider(): WeatherProvider = component.weatherProvider()
}