package com.example.newsapplication.ui.today

import androidx.compose.runtime.mutableStateListOf
import com.example.newsapplication.data.source.local.Article

class TodayScreenState {
    var listOfArticles = mutableStateListOf(ArticleCardUiState())
}

data class ArticleCardUiState (
    var heading : String = "Error 404",
    var body : String = "Error 404",
    var xMinRead : Int = 404
        )
fun Article.toArticleCardUiState() : ArticleCardUiState{
    return ArticleCardUiState(
        heading = this.title,
        body = this.summary,
        xMinRead = this.lengthOfArticleInMinutes
    )
}
