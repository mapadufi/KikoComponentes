package com.kiko.kikocomponentes.ui.screens.datetime

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
import com.kiko.kikocomponentes.components.datetime.DataPickerKiko
import com.kiko.kikocomponentes.components.datetime.DatePickerDockedKiko
import com.kiko.kikocomponentes.components.datetime.DatePickerFieldToModalKiko
import com.kiko.kikocomponentes.components.divider.HorizontalDividerKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun DatePickerScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val datePickerCode = """
        // DatePicker Inline
        DataPickerKiko()

        // DatePicker Docked
        DatePickerDockedKiko()

        // DatePicker Field to Modal
        DatePickerFieldToModalKiko()
    """.trimIndent()

    LayoutBaseKiko(
        title = "Date Picker",
        onBack = onBack,
        componentCode = datePickerCode,
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
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "Seletores de Data",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Docked DatePicker", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                DatePickerDockedKiko()
            }

            HorizontalDividerKiko()

            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Modal DatePicker (Field)", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                DatePickerFieldToModalKiko()
            }

            HorizontalDividerKiko()

            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Inline DatePicker", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                DataPickerKiko()
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "DatePicker Screen Light")
@Composable
fun DatePickerScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        DatePickerScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "DatePicker Screen Dark")
@Composable
fun DatePickerScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        DatePickerScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
