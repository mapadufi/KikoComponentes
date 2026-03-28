package com.kiko.kikocomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kiko.kikocomponentes.ui.screens.main.MainScreen
import com.kiko.kikocomponentes.ui.screens.splash.SplashScreen
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme
import com.kiko.kikocomponentes.viewmodel.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeViewModel: ThemeViewModel = viewModel()
            val themeType by themeViewModel.themeType.collectAsState()
            val isDarkMode by themeViewModel.isDarkMode.collectAsState()

            KikoComponentesTheme(
                themeType = themeType,
                darkTheme = isDarkMode
            ) {
                var showSplash by remember { mutableStateOf(true) }

                if (showSplash) {
                    SplashScreen(onNavigateNext = { showSplash = false })
                } else {
                    MainScreen()
                }
            }
        }
    }
}
