package com.kiko.kikocomponentes.ui.screens.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.buttons.SplitButtonKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun SplitButtonScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val componentCode = """
        SplitButtonKiko(
            text = "Enviar",
            onMainClick = { /* ação principal */ },
            onArrowClick = { /* abrir menu */ }
        )
    """.trimIndent()

    LayoutBaseKiko(
        title = "Split Button",
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Exemplo de SplitButton",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            SplitButtonKiko(
                text = "Enviar",
                onMainClick = {},
                onArrowClick = {}
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "O botão acima combina uma ação principal com um menu de opções.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "SplitButton Screen Light")
@Composable
fun SplitButtonScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        SplitButtonScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "SplitButton Screen Dark")
@Composable
fun SplitButtonScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        SplitButtonScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
