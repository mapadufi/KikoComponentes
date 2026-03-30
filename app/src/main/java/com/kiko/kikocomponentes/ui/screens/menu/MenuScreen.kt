package com.kiko.kikocomponentes.ui.screens.menu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.divider.HorizontalDividerKiko
import com.kiko.kikocomponentes.components.menu.DropDownMenuKiko
import com.kiko.kikocomponentes.components.menu.ExposedDropDownMenuKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun MenuScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val menuCode = """
        // Standard DropDown Menu
        DropDownMenuKiko()

        // Exposed DropDown Menu (Select)
        ExposedDropDownMenuKiko()
    """.trimIndent()

    LayoutBaseKiko(
        title = "Menus",
        onBack = onBack,
        componentCode = menuCode,
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
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                text = "Exemplos de Menus",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Standard DropDown Menu", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(16.dp))
                DropDownMenuKiko()
            }

            HorizontalDividerKiko()

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Exposed DropDown Menu (Select)", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(16.dp))
                ExposedDropDownMenuKiko()
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Menu Screen Light")
@Composable
fun MenuScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        MenuScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Menu Screen Dark")
@Composable
fun MenuScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        MenuScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
