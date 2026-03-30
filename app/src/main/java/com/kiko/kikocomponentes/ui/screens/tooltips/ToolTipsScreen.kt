package com.kiko.kikocomponentes.ui.screens.tooltips

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.tooltips.PlainTooltipKiko
import com.kiko.kikocomponentes.components.tooltips.RichTooltipKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ToolTipsScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val tooltipsCode = """
        // Tooltip Simples (Plain)
        PlainTooltipKiko(tooltipText = "Mensagem simples") {
            Button(onClick = { }) { Text("Hover me") }
        }

        // Tooltip Rico (Rich)
        RichTooltipKiko(
            title = "Dica",
            text = "Explicação detalhada sobre a funcionalidade.",
            action = { TextButton(onClick = { }) { Text("Saiba mais") } }
        ) {
            Icon(Icons.Default.Info, contentDescription = null)
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Tooltips",
        onBack = onBack,
        componentCode = tooltipsCode,
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
            verticalArrangement = Arrangement.spacedBy(48.dp, Alignment.CenterVertically)
        ) {
            Text(
                text = "Dicas Flutuantes (Tooltips)",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Plain Tooltip", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(16.dp))
                PlainTooltipKiko(tooltipText = "Este é um tooltip simples") {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
                    ) {
                        Text("Passe o mouse (ou segure)")
                    }
                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Rich Tooltip", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(16.dp))
                RichTooltipKiko(
                    title = "Dica Importante",
                    text = "Este é um rich tooltip que pode conter títulos e ações adicionais.",
                    action = {
                        TextButton(onClick = { }) {
                            Text("Saber mais", color = MaterialTheme.colorScheme.tertiary)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "ToolTips Screen Light")
@Composable
fun ToolTipsScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        ToolTipsScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "ToolTips Screen Dark")
@Composable
fun ToolTipsScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        ToolTipsScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
