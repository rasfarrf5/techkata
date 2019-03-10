package com.tech.kata.ui.main

import android.os.Bundle
import com.tech.kata.R
import com.tech.kata.TechKataApplication
import com.tech.kata.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun getToolbarTitle(): Int = R.string.app_name

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as TechKataApplication).getAppComponent().inject(this)

        presenter.setView(this)
        presenter.onViewCreated()
    }

    override fun showText(text: String) {
        mainScreenText.text = text
    }
}
