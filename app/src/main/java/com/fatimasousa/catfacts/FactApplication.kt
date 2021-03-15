package com.fatimasousa.catfacts

import android.app.Application
import com.fatimasousa.catfacts.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FactApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FactApplication)

            modules(mainModule)
        }
    }
}