package com.example.deliverandroid.model

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

object DI {

    private var application: Application? = null

    private val modules = listOf(
        AppModule.app,

    )

    fun start(app: Application) {
        application = app
        startKoin {

        }
    }



}