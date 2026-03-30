package com.kiko.kikocomponentes.ui.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.search.KikoSearchBar
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun SearchScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    val searchCode = """
        KikoSearchBar(
            hint = "Pesquisar...",
            onSearch = { query -> searchQuery = query },
            backgroundColor = MaterialTheme.colorScheme.surface
        )
    """.trimIndent()

    LayoutBaseKiko(
        title = "Search Bar",
        onBack = onBack,
        componentCode = searchCode,
        isDarkTheme = isDarkTheme,
        onDarkModeChange = onDarkModeChange,
        selectedTheme = selectedTheme,
        onThemeTypeChange = onThemeTypeChange
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Barra de Pesquisa Personalizada",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            KikoSearchBar(
                hint = "Pesquisar no catálogo...",
                onSearch = { searchQuery = it },
                backgroundColor = MaterialTheme.colorScheme.surface
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            if (searchQuery.isNotEmpty()) {
                Text(
                    text = "Você está pesquisando por: ${"$"}searchQuery",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Search Screen Light")
@Composable
fun SearchScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        SearchScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Search Screen Dark")
@Composable
fun SearchScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        SearchScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
