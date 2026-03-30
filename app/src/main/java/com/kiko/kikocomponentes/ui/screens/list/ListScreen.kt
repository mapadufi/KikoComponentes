package com.kiko.kikocomponentes.ui.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.R
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.list.KikoListItemData
import com.kiko.kikocomponentes.components.list.ListKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ListScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val listCode = """
        // Estrutura de dados
        data class KikoListItemData(val id: Int, val title: String, val imageRes: Int)

        // Exemplo de uso da lista
        ListKiko(
            items = listOf(
                KikoListItemData(1, "Item 1", R.drawable.fundo1),
                KikoListItemData(2, "Item 2", R.drawable.fundo2)
            ),
            onItemClick = { item -> /* ação */ }
        )
    """.trimIndent()

    val demoItems = listOf(
        KikoListItemData(1, "Cidade Expressiva", R.drawable.fundo1),
        KikoListItemData(2, "Montanhas Serenas", R.drawable.fundo2),
        KikoListItemData(3, "Oceano Profundo", R.drawable.fundo3),
        KikoListItemData(4, "Floresta Tropical", R.drawable.fundo4)
    )

    LayoutBaseKiko(
        title = "Lists",
        onBack = onBack,
        componentCode = listCode,
        isDarkTheme = isDarkTheme,
        onDarkModeChange = onDarkModeChange,
        selectedTheme = selectedTheme,
        onThemeTypeChange = onThemeTypeChange
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Demonstração de Lista",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }

            ListKiko(
                items = demoItems,
                onItemClick = { /* ação */ }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "List Screen Light")
@Composable
fun ListScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        ListScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "List Screen Dark")
@Composable
fun ListScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        ListScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
