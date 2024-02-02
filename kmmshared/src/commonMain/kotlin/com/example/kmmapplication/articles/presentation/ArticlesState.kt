package com.example.kmmapplication.articles.presentation

import com.example.kmmapplication.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)