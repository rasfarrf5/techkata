package com.tech.kata.weather

import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Answers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.math.BigDecimal

@RunWith(MockitoJUnitRunner::class)
class WeatherProviderTest {

    @InjectMocks
    private lateinit var subject: WeatherProvider

    @Mock
    private lateinit var weatherService: WeatherService

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private lateinit var weatherResponse: WeatherResponse

    @Test
    fun getWeather_returnsWeatherResultSuccess() {
        `when`(weatherResponse.main.temp).thenReturn(BigDecimal.ONE)
        `when`(weatherService.getWeatherDetails())
            .thenReturn(Observable.just(weatherResponse))

        val actual = subject.getWeather().test()

        actual.assertValue { result -> result is WeatherResult.Success }
    }

    @Test
    fun getWeather_returnsWeatherResultFailure() {
        `when`(weatherService.getWeatherDetails())
            .thenReturn(Observable.error(Throwable("")))

        val actual = subject.getWeather().test()

        actual.assertValue { result -> result is WeatherResult.Failed }
    }

    @Test
    fun getWeather_returnsWeatherResultSuccessWithTemp() {
        `when`(weatherResponse.main.temp).thenReturn(BigDecimal.ONE)
        `when`(weatherService.getWeatherDetails())
            .thenReturn(Observable.just(weatherResponse))

        val actual = subject.getWeather().test()

        actual.assertValue { result ->
            result is WeatherResult.Success
                    && result.temp == BigDecimal.ONE
        }

    }
}
