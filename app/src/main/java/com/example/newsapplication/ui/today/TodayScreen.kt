package com.example.newsapplication.ui.today

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                modifier = Modifier.fillMaxWidth().padding(start = 32.dp),
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

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TodayScreenPreview() {
    NewsApplicationTheme {
        TodayScreen()
    }
}


