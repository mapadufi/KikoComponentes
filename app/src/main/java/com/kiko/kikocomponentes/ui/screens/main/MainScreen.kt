package com.kiko.kikocomponentes.ui.screens.main

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.appbase.NavigationDrawerKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    onNavigateToComponent: (String) -> Unit = {},
    isDarkTheme: Boolean = false,
    onDarkModeChange: (Boolean) -> Unit = {},
    selectedTheme: AppThemeType = AppThemeType.PADRAO,
    onThemeTypeChange: (AppThemeType) -> Unit = {}
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    NavigationDrawerKiko(
        drawerState = drawerState,
        onItemClick = { route ->
            scope.launch { drawerState.close() }
            onNavigateToComponent(route)
        },
        onLogoutClick = {
            (context as? Activity)?.finishAffinity()
        }
    ) {
        LayoutBaseKiko(
            title = "Kiko Componentes",
            onMenuClick = {
                scope.launch { drawerState.open() }
            },
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
                    text = "Bem-vindo ao Catálogo",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Explore minha biblioteca de componentes modernos e expressivos feitos com Jetpack Compose. Navegue utilizando o menu lateral.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.tertiary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Main Screen Light")
@Composable
fun MainScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        MainScreen()
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Main Screen Dark")
@Composable
fun MainScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        MainScreen()
    }
}
