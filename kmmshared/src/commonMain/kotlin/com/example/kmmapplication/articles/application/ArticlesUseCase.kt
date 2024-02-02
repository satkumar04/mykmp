package com.example.kmmapplication.articles.application

import com.example.kmmapplication.articles.data.ArticleRaw
import com.example.kmmapplication.articles.data.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private  val repo: ArticlesRepository) {

    suspend fun getArticles(forceFetch:Boolean):List<Article> {
        val articleRaw = repo.getArticles(forceFetch)
        return mapArticles(articleRaw)
    }

    private fun mapArticles(articleRaw: List<ArticleRaw>): List<Article> = articleRaw.map { raw ->
        Article(
            raw.title,
            raw.desc ?: "",
            getDaysAgoString(raw.date),
            imageUrl = raw.imageUrl
                ?: "https://live-production.wcms.abc-cdn.net.au/2c549b8632fe75269dc461ca87b2868c?impolicy=wcms_crop_resize&cropH=540&cropW=960&xPos=0&yPos=0&width=862&height=485"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
    }