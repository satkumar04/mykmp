package com.example.kmmapplication.articles.data

import example.kmmapplication.db.DailyPulseDatabase

class ArticleDataSource(private  val database: DailyPulseDatabase) {
    fun getAllArticles(): List<ArticleRaw> =
        database.dailyPulseDatabaseQueries.selectArticle(::mapToArticleRaw).executeAsList()

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticleRaw = ArticleRaw(title, desc, date, url)


    fun insertArticles(articles: List<ArticleRaw>){
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() = database.dailyPulseDatabaseQueries.removeArticle()

    private fun insertArticle(articleRaw: ArticleRaw) {
      database.dailyPulseDatabaseQueries.insertArticle(
          articleRaw.title,articleRaw.desc,articleRaw.date,articleRaw.imageUrl)
    }

}

