package com.example.kmmapplication.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmmapplication.db.DatabaseDriverFactory
import example.kmmapplication.db.DailyPulseDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver>{DatabaseDriverFactory().createDriver()}

    single<DailyPulseDatabase> {DailyPulseDatabase(get())}

}