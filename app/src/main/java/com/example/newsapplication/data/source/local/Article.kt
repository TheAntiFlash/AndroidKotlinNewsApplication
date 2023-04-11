package com.example.newsapplication.data.source.local


data class Article(
    val heading : String,
    val imageURL : String,
    val author : String,
    val lengthOfArticleInMinutes : Int,
    val genre : String
)
