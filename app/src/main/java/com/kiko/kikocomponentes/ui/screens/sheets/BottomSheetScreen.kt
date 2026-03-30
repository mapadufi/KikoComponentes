package com.kiko.kikocomponentes.ui.screens.sheets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.buttons.KikoExtraButton
import com.kiko.kikocomponentes.components.sheets.BottonSheetsKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen(
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
        fun BottonSheetsKiko(
            onDismissRequest: () -> Unit,
            sheetState: SheetState = rememberModalBottomSheetState(),
            content: @Composable ColumnScope.() -> Unit
        ) {
            ModalBottomSheet(
                onDismissRequest = onDismissRequest,
                sheetState = sheetState,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                dragHandle = {
                    BottomSheetDefaults.DragHandle(
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp, start = 16.dp, end = 16.dp)
                ) {
                    content()
                }
            }
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Bottom Sheet",
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
                text = "Exemplo de BottomSheet",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            KikoExtraButton(
                text = "Abrir Bottom Sheet",
                onClick = { showSheet = true }
            )

            if (showSheet) {
                BottonSheetsKiko(
                    onDismissRequest = { showSheet = false },
                    sheetState = sheetState
                ) {
                    Text(
                        text = "Opções do Menu",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    
                    ListItem(
                        headlineContent = { Text("Adicionar Novo Item", color = MaterialTheme.colorScheme.tertiary) },
                        leadingContent = { Icon(Icons.Default.Add, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary) },
                        colors = ListItemDefaults.colors(containerColor = androidx.compose.ui.graphics.Color.Transparent)
                    )
                    ListItem(
                        headlineContent = { Text("Configurações Avançadas", color = MaterialTheme.colorScheme.tertiary) },
                        leadingContent = { Icon(Icons.Default.Add, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary) },
                        colors = ListItemDefaults.colors(containerColor = androidx.compose.ui.graphics.Color.Transparent)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "BottomSheet Screen Light")
@Composable
fun BottomSheetScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        BottomSheetScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "BottomSheet Screen Dark")
@Composable
fun BottomSheetScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        BottomSheetScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
