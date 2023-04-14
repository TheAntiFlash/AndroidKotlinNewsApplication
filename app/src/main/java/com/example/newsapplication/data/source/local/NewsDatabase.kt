package com.example.newsapplication.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun articleDao() : ArticleDao
}