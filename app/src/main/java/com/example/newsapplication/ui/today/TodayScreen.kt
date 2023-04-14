package com.example.newsapplication.ui.today

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapplication.ui.theme.NewsApplicationTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodayScreen( viewModel : TodayViewModel = hiltViewModel() ) {
    Scaffold(
        topBar = { Appbar(
            title = { Text("The New York Times", color = MaterialTheme.colors.onSurface, fontSize = 22.sp, fontWeight = FontWeight.SemiBold) }
        ) },
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {},
    ) {
        TodayArticles(articlesToday = viewModel.todayScreenState.listOfArticles.toList(), contentPadding = it)
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
fun TodayArticles(articlesToday : List<ArticleCardUiState>, contentPadding : PaddingValues) {
    LazyColumn(contentPadding = contentPadding, modifier = Modifier.background(MaterialTheme.colors.background))  {
        items(articlesToday) { item ->
            ArticleSection(heading = item.heading, body = item.body, xMinRead = item.xMinRead)
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            Divider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.padding(vertical = 20.dp))

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

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TodayScreenAppbarPreview() {
    NewsApplicationTheme {
        Appbar { Text("The New York Times", color = MaterialTheme.colors.onSurface, fontSize = 22.sp, fontWeight = FontWeight.SemiBold) }

    }
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticlesPreview(){
    val dummyArticles =  listOf(
        ArticleCardUiState(heading = "This is a Title For Article", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", xMinRead = 3),
        ArticleCardUiState(heading = "This is a Title For Article", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", xMinRead = 3),
        ArticleCardUiState(heading = "This is a Title For Article", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", xMinRead = 3),
        ArticleCardUiState(heading = "This is a Title For Article", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", xMinRead = 3),
        ArticleCardUiState(heading = "This is a Title For Article", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", xMinRead = 3),
        ArticleCardUiState(heading = "This is a Title For Article", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", xMinRead = 3),

    )
    NewsApplicationTheme {
        TodayArticles(articlesToday = dummyArticles , PaddingValues(16.dp))
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


