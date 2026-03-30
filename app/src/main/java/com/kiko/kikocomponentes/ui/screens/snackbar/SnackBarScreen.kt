package com.kiko.kikocomponentes.ui.screens.snackbar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.buttons.KikoExtraButton
import com.kiko.kikocomponentes.components.snackbar.SnackBarKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme
import kotlinx.coroutines.launch

@Composable
fun SnackBarScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val snackbarCode = """
        // Exemplo de uso do SnackBarKiko
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState) { data ->
                    SnackBarKiko(snackbarData = data)
                }
            }
        ) {
            KikoExtraButton(
                text = "Mostrar SnackBar",
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Ação realizada com sucesso!",
                            actionLabel = "Desfazer"
                        )
                    }
                }
            )
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Snackbar",
        onBack = onBack,
        componentCode = snackbarCode,
        isDarkTheme = isDarkTheme,
        onDarkModeChange = onDarkModeChange,
        selectedTheme = selectedTheme,
        onThemeTypeChange = onThemeTypeChange
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Exemplo de SnackBar",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
                
                Spacer(modifier = Modifier.height(32.dp))

                KikoExtraButton(
                    text = "Mostrar SnackBar",
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Esta é uma mensagem de alerta personalizada!",
                                actionLabel = "OK"
                            )
                        }
                    }
                )
            }

            // Host para o SnackBar aparecer na parte inferior
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 16.dp)
            ) { data ->
                SnackBarKiko(snackbarData = data)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "SnackBar Screen Light")
@Composable
fun SnackBarScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        SnackBarScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "SnackBar Screen Dark")
@Composable
fun SnackBarScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        SnackBarScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
