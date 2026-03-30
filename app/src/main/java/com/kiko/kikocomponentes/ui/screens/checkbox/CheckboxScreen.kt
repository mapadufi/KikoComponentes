package com.kiko.kikocomponentes.ui.screens.checkbox

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
import com.kiko.kikocomponentes.components.checkbox.MultiSelectCheckboxKiko
import com.kiko.kikocomponentes.components.checkbox.SelectAllCheckboxKiko
import com.kiko.kikocomponentes.components.checkbox.SimpleCheckboxKiko
import com.kiko.kikocomponentes.components.divider.HorizontalDividerKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun CheckboxScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val checkboxCode = """
        // Checkbox Simples
        SimpleCheckboxKiko(
            label = "Aceito os termos",
            checked = checked,
            onCheckedChange = { checked = it }
        )

        // Checkbox Multi-seleção
        MultiSelectCheckboxKiko()

        // Checkbox Tri-State (Marcar Todos)
        SelectAllCheckboxKiko()
    """.trimIndent()

    var simpleChecked by remember { mutableStateOf(false) }

    LayoutBaseKiko(
        title = "Checkbox",
        onBack = onBack,
        componentCode = checkboxCode,
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
                text = "Exemplos de Checkbox",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Checkbox Simples",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                SimpleCheckboxKiko(
                    label = "Aceito os termos",
                    checked = simpleChecked,
                    onCheckedChange = { simpleChecked = it }
                )
            }

            HorizontalDividerKiko()

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Multi-seleção",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                MultiSelectCheckboxKiko()
            }

            HorizontalDividerKiko()

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Marcar Todos (Tri-State)",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                SelectAllCheckboxKiko()
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Checkbox Screen Light")
@Composable
fun CheckboxScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        CheckboxScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Checkbox Screen Dark")
@Composable
fun CheckboxScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        CheckboxScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
