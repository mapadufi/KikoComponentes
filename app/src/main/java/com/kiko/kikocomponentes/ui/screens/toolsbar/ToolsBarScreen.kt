package com.kiko.kikocomponentes.ui.screens.toolsbar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.toolsbar.ToolsBarKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ToolsBarScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val componentCode = """
        @Composable
        fun ToolsBarKiko(
            modifier: Modifier = Modifier,
            onCheckClick: () -> Unit = {},
            onEditClick: () -> Unit = {},
            onMicClick: () -> Unit = {},
            onImageClick: () -> Unit = {},
            onFabClick: () -> Unit = {}
        ) {
            BottomAppBar(
                modifier = modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.tertiary,
                tonalElevation = 8.dp,
                actions = {
                    IconButton(onClick = onCheckClick) {
                        Icon(Icons.Filled.Check, contentDescription = "Check", tint = MaterialTheme.colorScheme.tertiary)
                    }
                    IconButton(onClick = onEditClick) {
                        Icon(Icons.Filled.Edit, contentDescription = "Edit", tint = MaterialTheme.colorScheme.tertiary)
                    }
                    IconButton(onClick = onMicClick) {
                        Icon(Icons.Filled.Mic, contentDescription = "Mic", tint = MaterialTheme.colorScheme.tertiary)
                    }
                    IconButton(onClick = onImageClick) {
                        Icon(Icons.Filled.Image, contentDescription = "Image", tint = MaterialTheme.colorScheme.tertiary)
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = onFabClick,
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = MaterialTheme.colorScheme.tertiaryContainer,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Add")
                    }
                }
            )
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Tools Bar",
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
                text = "Exemplo de ToolsBar",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            // Exibindo o componente
            ToolsBarKiko()
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "A barra acima é o componente ToolsBarKiko sendo demonstrado.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "ToolsBar Screen Light")
@Composable
fun ToolsBarScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        ToolsBarScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "ToolsBar Screen Dark")
@Composable
fun ToolsBarScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        ToolsBarScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
