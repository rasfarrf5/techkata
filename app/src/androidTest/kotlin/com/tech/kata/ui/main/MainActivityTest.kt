package com.tech.kata.ui.main

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private val mainActivityRobot = MainActivityRobot()

    @Before
    fun setUp() {
    }

    @Test
    fun changeText_sameActivity() {
        mainActivityRobot
            .seesMainText("Hello World")
    }
}