package com.tech.kata.common

import com.tech.kata.TechKataApplication
import com.tech.kata.ui.main.AppModule
import com.tech.kata.ui.main.MainActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,

            AppConfigModule::class,

            AppModule::class
        ]
)
interface AppComponent {

    fun inject(techKataApplication: TechKataApplication)

    fun inject(mainActivity: MainActivity)
}
