package com.tech.kata.ui.main

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @InjectMocks
    private lateinit var subject: MainPresenter

    @Mock
    private lateinit var view: MainContract.View

    @Before
    fun setUp() {
        subject.setView(view)
    }

    @Test
    fun onViewCreated_showText() {
        subject.onViewCreated()

        verify(view).showText("Hello World")
    }
}