package com.kiko.kikocomponentes.ui.screens.buttons

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
import com.kiko.kikocomponentes.components.buttons.*
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ButtonsScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val buttonsCode = """
        // Exemplo de uso dos botões Kiko
        FilledButtonKiko(onClick = { })
        FilledTonalButtonKiko(onClick = { })
        OutlinedButtonKiko(onClick = { })
        TextButtonKiko(onClick = { })
        KikoExtraButton(text = "Extra Button", onClick = { })
        PersonButtonKiko(onClick = { })
    """.trimIndent()

    LayoutBaseKiko(
        title = "Buttons",
        onBack = onBack,
        componentCode = buttonsCode,
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
                text = "Catálogo de Botões",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.tertiary
            )

            FilledButtonKiko()
            FilledTonalButtonKiko()
            OutlinedButtonKiko()
            TextButtonKiko()
            KikoExtraButton(text = "Kiko Extra Button")
            PersonButtonKiko()
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Buttons Screen Light")
@Composable
fun ButtonsScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        ButtonsScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Buttons Screen Dark")
@Composable
fun ButtonsScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        ButtonsScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
