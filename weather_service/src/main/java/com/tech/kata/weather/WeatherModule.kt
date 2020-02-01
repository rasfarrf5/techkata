package com.tech.kata.weather

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class WeatherModule(private val retrofit: Retrofit) {

    @Provides
    fun providesWeatherService(): WeatherService = retrofit.create(WeatherService::class.java)
}