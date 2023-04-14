package com.example.newsapplication.data.repository

import com.example.newsapplication.data.source.local.Article
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ArticlesRepository {

    fun getArticleStream(id : Int) : Flow<Article?>

    fun getArticlesStreamByDate(date: LocalDate) : Flow<List<Article?>>

    fun getAllArticlesStream() : Flow<List<Article>>
    suspend fun insertArticle(article: Article)

    suspend fun updateArticle(article: Article)

    suspend fun deleteArticle(article: Article)


}