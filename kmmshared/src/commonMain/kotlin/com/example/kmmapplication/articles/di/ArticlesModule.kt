package com.example.kmmapplication.articles.di
import com.example.kmmapplication.articles.data.ArticleDataSource
import com.example.kmmapplication.articles.data.ArticlesRepository
import com.example.kmmapplication.articles.data.ArticlesService
import com.example.kmmapplication.articles.application.ArticlesUseCase
import com.example.kmmapplication.articles.presentation.ArticlesViewModel
import org.koin.dsl.module
 val  articlesModule = module {
  single<ArticlesService> { ArticlesService(get()) }
  single<ArticlesUseCase> { ArticlesUseCase(get())  }
  single<ArticlesViewModel> { ArticlesViewModel(get())  }
  single<ArticleDataSource> { ArticleDataSource(get()) }
  single<ArticlesRepository> { ArticlesRepository(get(),get()) }
}