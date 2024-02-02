package com.example.kmmapplication.articles.data

import com.example.kmmapplication.articles.data.ArticleRaw
import com.example.kmmapplication.articles.data.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {
    private  val country = "us"
    private val category = "business"
    private  val apiKey = "6cdaa17a45f840e0affbbc2a5e010565"

    suspend fun fetchArticles(): List<ArticleRaw>{
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}