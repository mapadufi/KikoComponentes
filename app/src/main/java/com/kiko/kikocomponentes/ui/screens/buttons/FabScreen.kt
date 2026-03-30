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
import com.kiko.kikocomponentes.components.buttons.FabExtendedKiko
import com.kiko.kikocomponentes.components.buttons.FabLargeKiko
import com.kiko.kikocomponentes.components.buttons.FabSmallKiko
import com.kiko.kikocomponentes.components.buttons.FabSmallPersonKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun FabScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val fabCode = """
        // Exemplo de uso dos FABs Kiko
        FabSmallKiko(onClick = { })
        FabLargeKiko(onClick = { })
        FabExtendedKiko(onClick = { })
        FabSmallPersonKiko()
    """.trimIndent()

    LayoutBaseKiko(
        title = "Floating Action Buttons",
        onBack = onBack,
        componentCode = fabCode,
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
                text = "Exemplos de FABs",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text("Small FAB", color = MaterialTheme.colorScheme.tertiary)
            FabSmallKiko(onClick = {})

            Text("Large FAB", color = MaterialTheme.colorScheme.tertiary)
            FabLargeKiko(onClick = {})

            Text("Extended FAB", color = MaterialTheme.colorScheme.tertiary)
            FabExtendedKiko(onClick = {})

            Text("Interactive FAB Group", color = MaterialTheme.colorScheme.tertiary)
            FabSmallPersonKiko()
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Fab Screen Light")
@Composable
fun FabScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        FabScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Fab Screen Dark")
@Composable
fun FabScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        FabScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
