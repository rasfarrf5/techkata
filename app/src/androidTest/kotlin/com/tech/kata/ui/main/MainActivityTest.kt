package com.tech.kata.ui.main

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.tech.kata.ui.main.mockconfig.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    @get:Rule
    val mockWebServerRule = MockWebServerRule()

    private val mockWebServerRobot = MockWebServerRobot(mockWebServerRule)

    private val mainActivityRobot = MainActivityRobot()

    @Before
    fun setUp() {
    }

    @Test
    fun changeText_sameActivity() {
        mockWebServerRobot
            .useDefaultDispatcher()
            .performNoSyncAction(object : UserAction {
                override fun perform() {
                    mainActivityRobot
                        .seesMainText("201.32")
                }
            })
    }

    @Test
    fun changeText_sameActivity1() {
        mockWebServerRobot
            .useDefaultDispatcher()
            .performNoSyncAction(object : UserAction {
                override fun perform() {
                    mainActivityRobot
                        .seesMainText("201.32")
                }
            })
    }


}