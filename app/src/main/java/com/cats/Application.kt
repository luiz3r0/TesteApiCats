package com.cats

import android.app.Application
import com.cats.di.Module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@Application)
            modules(listOf(Module))
        }
    }
}