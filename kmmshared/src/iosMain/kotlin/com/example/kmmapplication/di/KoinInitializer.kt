package com.example.kmmapplication.di

import com.example.kmmapplication.articles.presentation.ArticlesViewModel
import com.example.kmmapplication.articles.di.sharedKoinModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin(){
    val modules = sharedKoinModule + databaseModule
    startKoin {
        modules(modules)
    }

}


class ArticlesInjector : KoinComponent{
    val articlesViewModel: ArticlesViewModel by inject()
}