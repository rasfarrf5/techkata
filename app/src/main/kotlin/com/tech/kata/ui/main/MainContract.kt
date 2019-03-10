package com.tech.kata.ui.main

class MainContract {

    interface View {

        fun showText(text: String)
    }

    interface Presenter {

        fun setView(view: View)

        fun onViewCreated()
    }
}