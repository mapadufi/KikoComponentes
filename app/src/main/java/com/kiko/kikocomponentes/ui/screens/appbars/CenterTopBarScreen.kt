package com.kiko.kikocomponentes.ui.screens.appbars

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbars.CenterTopBarKiko
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopBarScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val componentCode = """
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun CenterTopBarKiko(scrollBehavior: TopAppBarScrollBehavior? = null) {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    titleContentColor = MaterialTheme.colorScheme.tertiaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.tertiaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.tertiaryContainer
                ),
                title = {
                    Text(
                        "Text Centralizado",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* ação */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* ação */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Center Top Bar",
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
                text = "Exemplo de CenterTopBar",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            // Exibindo o componente
            CenterTopBarKiko()
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "A barra acima é o componente CenterTopBarKiko.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "CenterTopBar Screen Light")
@Composable
fun CenterTopBarScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        CenterTopBarScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "CenterTopBar Screen Dark")
@Composable
fun CenterTopBarScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        CenterTopBarScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
