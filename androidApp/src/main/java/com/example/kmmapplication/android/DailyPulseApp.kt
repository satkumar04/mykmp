package com.example.kmmapplication.android

import android.app.Application
import com.example.kmmapplication.android.di.databaseModule
import com.example.kmmapplication.android.di.viewModuleModels
import com.example.kmmapplication.articles.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModuleModels + databaseModule
        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}