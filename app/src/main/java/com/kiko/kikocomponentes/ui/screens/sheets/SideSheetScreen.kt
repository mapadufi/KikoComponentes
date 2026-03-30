package com.kiko.kikocomponentes.ui.screens.sheets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.buttons.KikoExtraButton
import com.kiko.kikocomponentes.components.buttons.OutlinedButtonKiko
import com.kiko.kikocomponentes.components.sheets.SideSheetKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SideSheetScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    val sheetCode = """
        @Composable
        fun SideSheetKiko(
            onDismissRequest: () -> Unit,
            sheetState: SheetState = rememberModalBottomSheetState(),
            content: @Composable ColumnScope.() -> Unit
        ) {
            ModalBottomSheet(
                onDismissRequest = onDismissRequest,
                sheetState = sheetState,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // ... content
                }
            }
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Side Sheet",
        onBack = onBack,
        componentCode = sheetCode,
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
                text = "Exemplo de SideSheet",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            KikoExtraButton(
                text = "Abrir Side Sheet",
                onClick = { showSheet = true }
            )

            if (showSheet) {
                SideSheetKiko(
                    onDismissRequest = { showSheet = false },
                    sheetState = sheetState
                ) {
                    Text(
                        text = "Configurações",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    Text(
                        text = "Este componente simula um SideSheet utilizando o padrão de BottomSheets para compatibilidade.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    OutlinedButtonKiko(
                        onClick = { showSheet = false },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "SideSheet Screen Light")
@Composable
fun SideSheetScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        SideSheetScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "SideSheet Screen Dark")
@Composable
fun SideSheetScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        SideSheetScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
