package com.tech.kata.common

import android.content.Context
import android.content.SharedPreferences
import com.tech.kata.TechKataApplication
import com.tech.kata.network.NetworkLibrary
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@Module
class AppConfigModule constructor(private val application: TechKataApplication) {

    @Provides
    fun providesApplication(): TechKataApplication = application

    @Provides
    fun providesContext(): Context = application.applicationContext

    @Provides
    fun providesNetworkLibrary(networkConfigurationImpl: NetworkConfigurationImpl): NetworkLibrary {
        return NetworkLibrary(networkConfigurationImpl)
    }

    @Provides
    fun providesNetworkConfiguration(context: Context) = NetworkConfigurationImpl(context)

    @Provides
    fun providesRetrofit(
        networkLibrary: NetworkLibrary
    ): Retrofit {
        val okHttpBuilder = networkLibrary.okHttpClient()
            .newBuilder()

        val okHttpClient = okHttpBuilder
            .build()
        return networkLibrary.retrofit().newBuilder().client(okHttpClient).build()
    }

    @Provides
    fun providesCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun providesSettingsPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences("tech_kata_preference", Context.MODE_PRIVATE)
    }
}