package com.tech.kata.ui.main

class MainContract {

    interface View {

        fun showText(text: String)

        fun showError()
    }

    interface Presenter {

        fun setView(view: View)

        fun onViewCreated()

        fun onViewPaused()
    }
}