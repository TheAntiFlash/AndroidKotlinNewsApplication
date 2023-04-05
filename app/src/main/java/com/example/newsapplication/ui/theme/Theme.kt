package com.example.newsapplication.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = ForegroundBlack,
    primaryVariant = ForegroundBlack,
    secondary = BackgroundWhite,
    background = BackgroundBlack,
    surface = ForegroundBlack,
    onSurface = WhiteText
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = BackgroundWhite,
    primaryVariant = BackgroundWhite,
    secondary = BackgroundBlack,
    surface = BackgroundWhite,
    onSurface = BlackText


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NewsApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}