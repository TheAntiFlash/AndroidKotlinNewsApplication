package com.example.newsapplication.ui.today

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapplication.ui.theme.NewsApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodayScreen() {
    val appbarColors = TopAppBarDefaults
        .centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colors.surface,
        titleContentColor = MaterialTheme.colors.onSurface)
    Scaffold(
        topBar = { TopBar(
            title = { Text("The New York Times", color = MaterialTheme.colors.onSurface) }
        ) },
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {},
    ) {
      Text(text = "TodayScreen",Modifier.padding(it))

        CenterAlignedTopAppBar(title = {Text("The New York Times", color = MaterialTheme.colors.onSurface)}, colors = appbarColors, )

    }
}


@Composable
fun TopBar(title : @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.surface,
        elevation = 3.dp
    ){
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        horizontalArrangement = Arrangement.Center) {
            title.invoke()


        }

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TodayScreenPreview() {
    NewsApplicationTheme {
        TodayScreen()
    }
}