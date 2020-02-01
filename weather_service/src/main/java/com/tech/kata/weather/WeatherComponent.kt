package com.tech.kata.weather

import dagger.Component

@Component(modules = [WeatherModule::class])
interface WeatherComponent {

    fun weatherProvider() : WeatherProvider
}