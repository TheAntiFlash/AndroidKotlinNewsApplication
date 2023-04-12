package com.example.newsapplication.ui.today

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapplication.data.source.local.Article
import com.example.newsapplication.ui.theme.NewsApplicationTheme

@Composable
fun TodayScreen() {
    Scaffold(
        topBar = { Appbar(
            title = { Text("The New York Times", color = MaterialTheme.colors.onSurface, fontSize = 22.sp, fontWeight = FontWeight.SemiBold) }
        ) },
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {},
    ) {
      Text(text = "TodayScreen",Modifier.padding(it))

        //CenterAlignedTopAppBar(title = {Text("The New York Times", color = MaterialTheme.colors.onSurface)}, colors = appbarColors, )

    }
}


@Composable
fun Appbar(title : @Composable () -> Unit) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) { title.invoke() }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Person, "Profile", Modifier.size(32.dp), tint = MaterialTheme.colors.onSurface)
            }
        }
    )
}

@Composable
fun TodayArticles(articlesToday : List<Article>) {
    LazyColumn {
        items(articlesToday) { item ->
            ArticleSection(heading = item.heading, body = item.summary, xMinRead = item.lengthOfArticleInMinutes)
        }
    }
}

@Composable
fun ArticleSection(heading : String, body : String, xMinRead : Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.Start
    ){

        Text(text = heading,
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.Black,
            fontSize = 32.sp
            )

        Text(text = body,
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.Light,
            fontSize = 18.sp
        )
        
        Text(text = "$xMinRead MIN READ",
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.ExtraLight,
            fontSize = 14.sp
            )

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

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleSectionPreview(){
    NewsApplicationTheme {
        ArticleSection(heading = "This is a Title For Article", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", xMinRead = 3)
    }
}


