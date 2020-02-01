package com.tech.kata.weather

import java.math.BigDecimal

data class WeatherResponse(val main: WeatherResponse.Main) {

    data class Main(val temp: BigDecimal)
}