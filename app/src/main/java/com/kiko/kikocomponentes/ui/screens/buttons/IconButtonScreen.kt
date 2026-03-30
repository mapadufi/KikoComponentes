package com.kiko.kikocomponentes.ui.screens.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.buttons.IconButtonBasicKiko
import com.kiko.kikocomponentes.components.buttons.IconButtonPersonKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun IconButtonScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    var count by remember { mutableIntStateOf(0) }
    
    val componentCode = """
        // Icon Button Básico
        IconButtonBasicKiko(onToggle = { })

        // Icon Button Person (Seletor)
        IconButtonPersonKiko(
            value = count,
            range = 0..10,
            onValueChange = { count = it }
        )
    """.trimIndent()

    LayoutBaseKiko(
        title = "Icon Buttons",
        onBack = onBack,
        componentCode = componentCode,
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
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
        ) {
            Text(
                text = "Exemplos de Icon Buttons",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Básico / Toggle", color = MaterialTheme.colorScheme.tertiary)
                IconButtonBasicKiko()
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Person Selector", color = MaterialTheme.colorScheme.tertiary)
                IconButtonPersonKiko(
                    value = count,
                    range = 0..10,
                    onValueChange = { count = it }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "IconButtons Screen Light")
@Composable
fun IconButtonScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        IconButtonScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "IconButtons Screen Dark")
@Composable
fun IconButtonScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        IconButtonScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
