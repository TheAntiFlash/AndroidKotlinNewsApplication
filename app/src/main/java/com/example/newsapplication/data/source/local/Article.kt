package com.example.newsapplication.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true) val articleId : Int,
    val title : String,
    val imageURL : String,
    val author : String,
    val lengthOfArticleInMinutes : Int,
    val genre : String,
    val content : String,
    val summary : String,
    val publishedDate: LocalDate
)
