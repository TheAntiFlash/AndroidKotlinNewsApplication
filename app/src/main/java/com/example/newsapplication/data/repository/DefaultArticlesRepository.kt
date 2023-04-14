package com.example.newsapplication.data.repository

import com.example.newsapplication.data.source.local.Article
import com.example.newsapplication.data.source.local.ArticleDao
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class DefaultArticlesRepository @Inject constructor(
    private val localDataSource: ArticleDao
) : ArticlesRepository{
    override fun getArticleStream(id: Int): Flow<Article?> = localDataSource.getArticleById(id)

    override fun getArticlesStreamByDate(date: LocalDate): Flow<List<Article?>> = localDataSource.getArticlesByDate(date)

    override fun getAllArticlesStream(): Flow<List<Article>> = localDataSource.getAllArticles()

    override suspend fun insertArticle(article: Article) = localDataSource.insert(article)

    override suspend fun updateArticle(article: Article) = localDataSource.update(article)
    override suspend fun deleteArticle(article: Article) = localDataSource.delete(article)
}