package com.example.newsapplication.ui.today

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.data.repository.ArticlesRepository
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
class TodayViewModel @Inject constructor(
    private val articlesRepository: ArticlesRepository
) : ViewModel() {
    var todayScreenState by mutableStateOf(TodayScreenState())

    init {
        viewModelScope.launch {
            val fetchedArticles = articlesRepository.getArticlesStreamByDate(LocalDate.of(2023,4,14))

            fetchedArticles.collect {
                for (article in it){
                    if (article != null) {
                        todayScreenState.listOfArticles.add(article.toArticleCardUiState())
                    }
                }
            }


        }
    }

}