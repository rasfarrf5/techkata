package com.tech.kata.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.tech.kata.R

class MainActivityRobot {

    fun seesMainText(titleString: String) {
        onView(withId(R.id.mainScreenText))
            .check(matches(withText(titleString)))
    }
}