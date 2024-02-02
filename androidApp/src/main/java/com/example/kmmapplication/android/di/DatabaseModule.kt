package com.example.kmmapplication.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmmapplication.db.DatabaseDriverFactory
import example.kmmapplication.db.DailyPulseDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val  databaseModule = module {
 single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver()  }
 single<DailyPulseDatabase> { DailyPulseDatabase(get())  }
}