package com.kiko.kikocomponentes.ui.screens.radiobutton

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
import com.kiko.kikocomponentes.components.radiobutton.RadioButtonGroupKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun RadioButtonScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    var selectedOption by remember { mutableStateOf("Opção 1") }
    val options = listOf("Opção 1", "Opção 2", "Opção 3")

    val radioCode = """
        var selectedOption by remember { mutableStateOf("Opção 1") }
        val options = listOf("Opção 1", "Opção 2", "Opção 3")

        RadioButtonGroupKiko(
            options = options,
            selectedOption = selectedOption,
            onOptionSelected = { selectedOption = it }
        )
    """.trimIndent()

    LayoutBaseKiko(
        title = "Radio Button",
        onBack = onBack,
        componentCode = radioCode,
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
                text = "Seleção de Opção Única",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            RadioButtonGroupKiko(
                options = options,
                selectedOption = selectedOption,
                onOptionSelected = { selectedOption = it }
            )
            
            Text(
                text = "Opção selecionada: ${selectedOption}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "RadioButton Screen Light")
@Composable
fun RadioButtonScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        RadioButtonScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "RadioButton Screen Dark")
@Composable
fun RadioButtonScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        RadioButtonScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
