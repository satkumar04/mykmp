package com.example.kmmapplication.android.di

import com.example.kmmapplication.articles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModuleModels = module {
    viewModel {
        ArticlesViewModel(get())
    }
}