package com.kiko.kikocomponentes.ui.screens.`switch`

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.`switch`.SwitchKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun SwitchScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    var checked by remember { mutableStateOf(true) }

    val switchCode = """
        // Exemplo de SwitchKiko
        var checked by remember { mutableStateOf(true) }
        
        SwitchKiko(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    """.trimIndent()

    LayoutBaseKiko(
        title = "Switch",
        onBack = onBack,
        componentCode = switchCode,
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
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Exemplo de Switch",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = if (checked) "Ligado" else "Desligado",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.bodyLarge
                )
                SwitchKiko(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "O SwitchKiko possui ícones internos personalizados para indicar o estado.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Switch Screen Light")
@Composable
fun SwitchScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        SwitchScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Switch Screen Dark")
@Composable
fun SwitchScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        SwitchScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
