package com.example.newsapplication.ui.today

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapplication.ui.theme.NewsApplicationTheme

@Composable
fun TodayScreen() {
    Scaffold(
        topBar = { TopBar() },
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {},
    ) {
      Text(text = "TodayScreen",Modifier.padding(it))
    }
}

@Composable
fun TopBar() {

}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED)
@Composable
fun TodayScreenPreview() {
    NewsApplicationTheme {
        TodayScreen()
    }
}