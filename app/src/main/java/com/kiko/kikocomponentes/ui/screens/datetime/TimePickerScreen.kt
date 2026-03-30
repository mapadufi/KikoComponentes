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
import com.kiko.kikocomponentes.components.datetime.TimeInputKiko
import com.kiko.kikocomponentes.components.datetime.TimePickerFieldToModalKiko
import com.kiko.kikocomponentes.components.datetime.TimePickerKiko
import com.kiko.kikocomponentes.components.divider.HorizontalDividerKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun TimePickerScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val timePickerCode = """
        // TimePicker Inline
        TimePickerKiko()

        // TimeInput Inline
        TimeInputKiko()

        // TimePicker Field to Modal
        TimePickerFieldToModalKiko()
    """.trimIndent()

    LayoutBaseKiko(
        title = "Time Picker",
        onBack = onBack,
        componentCode = timePickerCode,
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
                text = "Seletores de Hora",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text("TimePicker Modal (Field)", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                TimePickerFieldToModalKiko()
            }

            HorizontalDividerKiko()

            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("TimePicker Inline", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                TimePickerKiko()
            }

            HorizontalDividerKiko()

            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("TimeInput Inline", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                TimeInputKiko()
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "TimePicker Screen Light")
@Composable
fun TimePickerScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        TimePickerScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "TimePicker Screen Dark")
@Composable
fun TimePickerScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        TimePickerScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
