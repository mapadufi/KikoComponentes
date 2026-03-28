package com.kiko.kikocomponentes.components.appbase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme


@Composable
fun LayoutBaseKiko(
    title: String = "Kiko Componentes",
    onBack: (() -> Unit)? = null,
    onMenuClick: (() -> Unit)? = null,
    componentCode: String = "",
    isDarkTheme: Boolean = false,
    onDarkModeChange: (Boolean) -> Unit = {},
    selectedTheme: AppThemeType = AppThemeType.PADRAO,
    onThemeTypeChange: (AppThemeType) -> Unit = {},
    topBar: @Composable () -> Unit = { 
        AppBarKiko(
            title = title, 
            onBack = onBack,
            onMenuClick = onMenuClick
        ) 
    },
    bottomBar: @Composable () -> Unit = {
        Column {
            ThemeSelectorBaseKiko(
                isDarkTheme = isDarkTheme,
                onDarkModeChange = onDarkModeChange,
                selectedTheme = selectedTheme,
                onThemeTypeChange = onThemeTypeChange
            )
            ShareIconsBaseKiko(
                componentCode = componentCode,
                componentName = title
            )
            BottomBarBaseKiko()
        }
    },
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = topBar,
        bottomBar = bottomBar,
        content = content
    )
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "LayoutBase Light")
@Composable
fun LayoutBaseKikoPreviewLight() {
    KikoComponentesTheme (darkTheme = false) {
        LayoutBaseKiko(
            title = "Preview Light",
            onMenuClick = {},
            componentCode = "fun Exemplo() { }",
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Conteúdo da Tela", color = MaterialTheme.colorScheme.tertiary)
            }
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "LayoutBase Dark")
@Composable
fun LayoutBaseKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        LayoutBaseKiko(
            title = "Preview Dark",
            onMenuClick = {},
            componentCode = "fun Exemplo() { }",
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Conteúdo da Tela", color = MaterialTheme.colorScheme.tertiary)
            }
        }
    }
}
