package com.example.deliverandroid

import android.app.Application
import com.example.deliverandroid.model.DI
import timber.log.Timber


class DeliverApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        DI.start(this)

    }
}