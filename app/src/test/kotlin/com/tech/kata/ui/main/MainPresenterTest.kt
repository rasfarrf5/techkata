package com.tech.kata.ui.main

import com.tech.kata.weather.WeatherProvider
import com.tech.kata.weather.WeatherResult
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.math.BigDecimal

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @InjectMocks
    private lateinit var subject: MainPresenter

    @Mock
    private lateinit var weatherProvider: WeatherProvider
    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var weatherResultSucess: WeatherResult.Success
    @Mock
    private lateinit var weatherResultFailed: WeatherResult.Failed
    @Mock
    private lateinit var view: MainContract.View

    @Before
    fun setUp() {
        subject.setView(view)
    }

    @Test
    fun onViewCreated_givenWeatherResultSuccess_showText() {
        `when`(weatherResultSucess.temp)
            .thenReturn(BigDecimal.valueOf(11.11))
        `when`(weatherProvider.getWeather())
            .thenReturn(Observable.just(weatherResultSucess))

        subject.onViewCreated()

        verify(view).showText("11.11")
    }

    @Test
    fun onViewCreated_givenWeatherResultFailed_showError() {
        `when`(weatherProvider.getWeather())
            .thenReturn(Observable.just(weatherResultFailed))

        subject.onViewCreated()

        verify(view).showError()
    }

    @Test
    fun onViewPaused_clearObservables() {
        subject.onViewPaused()

        verify(compositeDisposable).clear()
    }
}