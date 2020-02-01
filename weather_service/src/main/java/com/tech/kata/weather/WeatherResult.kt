package com.tech.kata.weather

import java.math.BigDecimal

sealed class WeatherResult {

    data class Success(val temp: BigDecimal) : WeatherResult()

    class Failed : WeatherResult()
}
