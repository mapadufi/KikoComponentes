package com.kiko.kikocomponentes.ui.screens.chips

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.chips.AssistChipKiko
import com.kiko.kikocomponentes.components.chips.FilterChipKiko
import com.kiko.kikocomponentes.components.chips.InputChipKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ChipsScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val chipsCode = """
        // Exemplo de Chips Kiko
        AssistChipKiko()
        FilterChipKiko()
        InputChipKiko(text = "Tag", onDismiss = { })
    """.trimIndent()

    LayoutBaseKiko(
        title = "Chips",
        onBack = onBack,
        componentCode = chipsCode,
        isDarkTheme = isDarkTheme,
        onDarkModeChange = onDarkModeChange,
        selectedTheme = selectedTheme,
        onThemeTypeChange = onThemeTypeChange
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "Catálogo de Chips",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Assist Chip", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
                AssistChipKiko()
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Filter Chip", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
                FilterChipKiko()
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Input Chip", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
                InputChipKiko()
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Chips Screen Light")
@Composable
fun ChipsScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        ChipsScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Chips Screen Dark")
@Composable
fun ChipsScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        ChipsScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
