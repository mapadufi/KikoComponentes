package com.kiko.kikocomponentes.ui.screens.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbars.BottomBarKiko
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun BottomBarScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val bottomBarCode = """
        @Composable
        fun BottomBarKiko() {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.tertiaryContainer,
                actions = {
                    IconButton(onClick = { /* ação */ }) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Check"
                        )
                    }
                    IconButton(onClick = { /* ação */ }) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Edit"
                        )
                    }
                    IconButton(onClick = { /* ação */ }) {
                        Icon(
                            imageVector = Icons.Filled.Mic,
                            contentDescription = "Mic"
                        )
                    }
                    IconButton(onClick = { /* ação */ }) {
                        Icon(
                            imageVector = Icons.Filled.Image,
                            contentDescription = "Image"
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* ação */ },
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.tertiary,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add"
                        )
                    }
                }
            )
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Bottom App Bar",
        onBack = onBack,
        componentCode = bottomBarCode,
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
                text = "Exemplo de BottomAppBar",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            // Exibindo o componente
            BottomBarKiko()
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "A barra acima é o componente BottomBarKiko sendo exibido.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "BottomBar Screen Light")
@Composable
fun BottomBarScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        BottomBarScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "BottomBar Screen Dark")
@Composable
fun BottomBarScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        BottomBarScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
