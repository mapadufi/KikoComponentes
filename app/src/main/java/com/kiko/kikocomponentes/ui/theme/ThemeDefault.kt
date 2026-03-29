package com.kiko.kikocomponentes.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

val DarkDefaultColorScheme = darkColorScheme(
    primary = Primary900,
    onPrimary = Dark700,
    tertiary = Primary400,
    onTertiary = Primary300,
    background = Dark900,
    surface = Dark700,
    outline = Dark950,
    error = Error900
)

val LightDefaultColorScheme = lightColorScheme(
    primary = Primary900,
    onPrimary = BrancoApp,
    tertiary = Primary900,
    onTertiary = BrancoApp,
    background = BrancoApp,
    surface = BrancoApp,
    outline = Primary900,
    error = Error900
)
