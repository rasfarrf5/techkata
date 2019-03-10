package com.tech.kata.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.tech.kata.R
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    @StringRes
    protected abstract fun getToolbarTitle(): Int

    protected open fun enableBackButton(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        setSupportActionBar(toolbar)

        if (getToolbarTitle() != 0)
            supportActionBar?.title = "  " + getString(getToolbarTitle())
        else
            supportActionBar?.title = getString(R.string.app_name)

        supportActionBar?.setDisplayHomeAsUpEnabled(enableBackButton())
    }
}