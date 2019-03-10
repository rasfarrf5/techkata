package com.tech.kata.common

import android.content.Context
import com.tech.kata.network.NetworkConfiguration
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.File

class NetworkConfigurationImpl(val context: Context) :
    NetworkConfiguration {
    override fun mainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()

    override fun ioScheduler(): Scheduler = Schedulers.io()

    override fun getHost(): String = "http://www.google.com/"

    override fun getCacheDir(): File = context.cacheDir

    override fun getCacheSize(): Long = 2 * 1024

    override fun getTimeoutSeconds(): Long = 5000
}