package com.kiko.kikocomponentes.ui.screens.toast

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
import com.kiko.kikocomponentes.components.buttons.KikoExtraButton
import com.kiko.kikocomponentes.components.toast.KikoAttentionToast
import com.kiko.kikocomponentes.components.toast.KikoErrorToast
import com.kiko.kikocomponentes.components.toast.KikoSuccessToast
import com.kiko.kikocomponentes.components.toast.KikoDeleteToast
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme
import kotlinx.coroutines.delay

@Composable
fun ToastScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    var visibleToast by remember { mutableStateOf<String?>(null) }

    // Lógica para esconder o toast após 3 segundos
    LaunchedEffect(visibleToast) {
        if (visibleToast != null) {
            delay(3000)
            visibleToast = null
        }
    }

    val toastCode = """
        // Exemplo de uso dos Toasts Kiko
        KikoSuccessToast(message = "Sucesso!")
        KikoErrorToast(message = "Erro!")
        KikoAttentionToast(message = "Atenção!")
        KikoDeleteToast(message = "Excluído!")
    """.trimIndent()

    LayoutBaseKiko(
        title = "Toasts",
        onBack = onBack,
        componentCode = toastCode,
        isDarkTheme = isDarkTheme,
        onDarkModeChange = onDarkModeChange,
        selectedTheme = selectedTheme,
        onThemeTypeChange = onThemeTypeChange
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
            ) {
                Text(
                    text = "Demonstração de Toasts",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )

                KikoExtraButton(
                    text = "Mostrar Toast Sucesso",
                    onClick = { visibleToast = "success" }
                )

                KikoExtraButton(
                    text = "Mostrar Toast Erro",
                    onClick = { visibleToast = "error" }
                )

                KikoExtraButton(
                    text = "Mostrar Toast Atenção",
                    onClick = { visibleToast = "attention" }
                )

                KikoExtraButton(
                    text = "Mostrar Toast Exclusão",
                    onClick = { visibleToast = "delete" }
                )
            }

            // Overlay do Toast selecionado (aparece no topo ou centro)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                when (visibleToast) {
                    "success" -> KikoSuccessToast(message = "Operação realizada com sucesso!")
                    "error" -> KikoErrorToast(message = "Ocorreu um erro inesperado!")
                    "attention" -> KikoAttentionToast(message = "Fique atento aos detalhes!")
                    "delete" -> KikoDeleteToast(message = "Item removido permanentemente!")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Toast Screen Light")
@Composable
fun ToastScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        ToastScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Toast Screen Dark")
@Composable
fun ToastScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        ToastScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
