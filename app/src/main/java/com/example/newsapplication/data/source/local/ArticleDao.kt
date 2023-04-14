package com.example.newsapplication.data.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.util.*

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(article: Article)

    @Update
    suspend fun update(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM articles WHERE publishedDate = :date")
    fun getArticlesByDate(date : LocalDate) : Flow<List<Article>>

    @Query("Select * FROM articles WHERE articleId = :id")
    fun getArticleById(id : Int) : Flow<Article>

    @Query("SELECT * FROM articles")
    fun getAllArticles() : Flow<List<Article>>
}