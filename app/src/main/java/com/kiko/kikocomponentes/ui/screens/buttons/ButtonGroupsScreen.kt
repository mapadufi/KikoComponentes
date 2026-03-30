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
import com.kiko.kikocomponentes.components.buttons.ButtonGroupsKiko
import com.kiko.kikocomponentes.components.buttons.MultiChoiceSegmentedButton
import com.kiko.kikocomponentes.components.buttons.SingleSegmentedButtonKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ButtonGroupsScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    var selectedGroupOption by remember { mutableStateOf("Opção 1") }
    
    val componentCode = """
        // Button Groups Customizado
        ButtonGroupsKiko(
            options = listOf("Opção 1", "Opção 2", "Opção 3"),
            selectedOption = selectedOption,
            onOptionSelected = { selectedOption = it }
        )

        // Segmented Button (Single Choice)
        SingleSegmentedButtonKiko()

        // Segmented Button (Multi Choice)
        MultiChoiceSegmentedButton()
    """.trimIndent()

    LayoutBaseKiko(
        title = "Button Groups",
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
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                text = "Agrupamentos de Botões",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Custom Button Group", color = MaterialTheme.colorScheme.tertiary)
                ButtonGroupsKiko(
                    options = listOf("Opção 1", "Opção 2", "Opção 3"),
                    selectedOption = selectedGroupOption,
                    onOptionSelected = { selectedGroupOption = it }
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Single Choice Segmented", color = MaterialTheme.colorScheme.tertiary)
                SingleSegmentedButtonKiko()
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Multi Choice Segmented", color = MaterialTheme.colorScheme.tertiary)
                MultiChoiceSegmentedButton()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "ButtonGroups Screen Light")
@Composable
fun ButtonGroupsScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        ButtonGroupsScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "ButtonGroups Screen Dark")
@Composable
fun ButtonGroupsScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        ButtonGroupsScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
