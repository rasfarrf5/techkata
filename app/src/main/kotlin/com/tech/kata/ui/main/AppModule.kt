package com.tech.kata.ui.main

import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun providesMainPresenter(mainPresenter: MainPresenter): MainContract.Presenter
}
