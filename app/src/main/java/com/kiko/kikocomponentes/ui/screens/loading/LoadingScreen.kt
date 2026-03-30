package com.kiko.kikocomponentes.ui.screens.loading

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.loadingprogress.CircularProgressAngularKiko
import com.kiko.kikocomponentes.components.loadingprogress.LoadingIndicatorKiko
import com.kiko.kikocomponentes.components.loadingprogress.ProgressAngularKiko
import com.kiko.kikocomponentes.components.loadingprogress.ProgressCircularKiko
import com.kiko.kikocomponentes.components.loadingprogress.ProgressLinearKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoadingScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val loadingCode = """
        // Progress Indicators
        ProgressLinearKiko()
        ProgressCircularKiko()
        
        // Expressive Indicators (Wavy)
        ProgressAngularKiko()
        CircularProgressAngularKiko()
        
        // Loading Indicator (Polygon)
        LoadingIndicatorKiko()
    """.trimIndent()

    LayoutBaseKiko(
        title = "Loading & Progress",
        onBack = onBack,
        componentCode = loadingCode,
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
                text = "Indicadores de Carregamento",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Linear Progress", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                ProgressLinearKiko(modifier = Modifier.fillMaxWidth())
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Circular Progress", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                ProgressCircularKiko()
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Expressive (Wavy) Linear", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                ProgressAngularKiko(modifier = Modifier.fillMaxWidth())
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Expressive (Wavy) Circular", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                CircularProgressAngularKiko()
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Loading Indicator (Polygon)", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(8.dp))
                LoadingIndicatorKiko()
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Loading Screen Light")
@Composable
fun LoadingScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        LoadingScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Loading Screen Dark")
@Composable
fun LoadingScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        LoadingScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
