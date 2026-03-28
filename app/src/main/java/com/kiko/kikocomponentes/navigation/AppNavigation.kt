package com.kiko.kikocomponentes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kiko.kikocomponentes.ui.screens.alertdialog.AlertDialogScreen
import com.kiko.kikocomponentes.ui.screens.main.MainScreen
import com.kiko.kikocomponentes.ui.screens.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // Tela de Splash
        composable(Screen.Splash.route) {
            SplashScreen(onNavigateNext = {
                navController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }

        // Tela Principal (Catálogo)
        composable(Screen.Main.route) {
            MainScreen(
                onNavigateToComponent = { route ->
                    navController.navigate(route)
                }
            )
        }

        // Tela do componente Alert Dialog
        composable(Screen.AlertDialog.route) {
            AlertDialogScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
