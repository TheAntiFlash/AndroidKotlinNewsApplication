package com.example.newsapplication.di

import android.content.Context
import androidx.room.Room
import com.example.newsapplication.data.repository.ArticlesRepository
import com.example.newsapplication.data.repository.DefaultArticlesRepository
import com.example.newsapplication.data.source.local.ArticleDao
import com.example.newsapplication.data.source.local.NewsDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : NewsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NewsDatabase::class.java,
            "News.db"
        ).build()
    }

    @Provides
    fun provideArticleDao(database: NewsDatabase) : ArticleDao = database.articleDao()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindArticlesRepository(defaultArticlesRepository: DefaultArticlesRepository) : ArticlesRepository
}