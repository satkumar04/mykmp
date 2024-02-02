package com.example.kmmapplication.articles.di

import com.example.kmmapplication.di.networkModule

val sharedKoinModule = listOf(
    articlesModule,
    networkModule
)