package com.tech.kata.ui.main

import com.tech.kata.weather.WeatherProvider
import com.tech.kata.weather.WeatherResult
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val weatherProvider: WeatherProvider,
    private val compositeDisposable: CompositeDisposable
) : MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun onViewCreated() {
        val disposable = weatherProvider.getWeather()
            .subscribe { result ->
                if (result is WeatherResult.Success)
                    view.showText("${result.temp}")
                else
                    view.showError()
            }

        compositeDisposable.add(disposable)
    }

    override fun onViewPaused() {
        compositeDisposable.clear()
    }
}
