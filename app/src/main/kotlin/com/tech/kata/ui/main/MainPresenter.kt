package com.tech.kata.ui.main

import javax.inject.Inject

class MainPresenter @Inject constructor() : MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun onViewCreated() {
        view.showText("Hello World")
    }
}