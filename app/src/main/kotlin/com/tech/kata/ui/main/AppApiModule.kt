package com.tech.kata.ui.main

import com.tech.kata.weather.WeatherLibrary
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AppApiModule {

    @Provides
    fun providesWeatherLibrary(retrofit: Retrofit) = WeatherLibrary(retrofit)

    @Provides
    fun providesWeatherProvider(weatherLibrary: WeatherLibrary) = weatherLibrary.weatherProvider()
}
