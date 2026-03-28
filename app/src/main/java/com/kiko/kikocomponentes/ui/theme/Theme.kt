package com.kiko.kikocomponentes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.kiko.kofre.ui.theme.DarkDefaultColorScheme
import com.kiko.kofre.ui.theme.DarkRoxoColorScheme
import com.kiko.kofre.ui.theme.DarkVerdeColorScheme
import com.kiko.kofre.ui.theme.DarkVermelhoColorScheme
import com.kiko.kofre.ui.theme.LightDefaultColorScheme
import com.kiko.kofre.ui.theme.LightRoxoColorScheme
import com.kiko.kofre.ui.theme.LightVerdeColorScheme
import com.kiko.kofre.ui.theme.LightVermelhoColorScheme

@Composable
fun KikoComponentesTheme(
    themeType: AppThemeType = AppThemeType.PADRAO,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when (themeType) {
        AppThemeType.PADRAO -> if (darkTheme) DarkDefaultColorScheme else LightDefaultColorScheme
        AppThemeType.VERDE -> if (darkTheme) DarkVerdeColorScheme else LightVerdeColorScheme
        AppThemeType.VERMELHO -> if (darkTheme) DarkVermelhoColorScheme else LightVermelhoColorScheme
        AppThemeType.ROXO -> if (darkTheme) DarkRoxoColorScheme else LightRoxoColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
