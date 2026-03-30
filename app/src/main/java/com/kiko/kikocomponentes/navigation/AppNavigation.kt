package com.kiko.kikocomponentes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kiko.kikocomponentes.ui.screens.alertdialog.AlertDialogScreen
import com.kiko.kikocomponentes.ui.screens.appbars.*
import com.kiko.kikocomponentes.ui.screens.badges.BadgeScreen
import com.kiko.kikocomponentes.ui.screens.buttons.*
import com.kiko.kikocomponentes.ui.screens.cards.CardsScreen
import com.kiko.kikocomponentes.ui.screens.caroussel.CarouselScreen
import com.kiko.kikocomponentes.ui.screens.checkbox.CheckboxScreen
import com.kiko.kikocomponentes.ui.screens.chips.ChipsScreen
import com.kiko.kikocomponentes.ui.screens.datetime.DatePickerScreen
import com.kiko.kikocomponentes.ui.screens.datetime.TimePickerScreen
import com.kiko.kikocomponentes.ui.screens.divider.DividerScreen
import com.kiko.kikocomponentes.ui.screens.list.ListScreen
import com.kiko.kikocomponentes.ui.screens.loading.LoadingScreen
import com.kiko.kikocomponentes.ui.screens.main.MainScreen
import com.kiko.kikocomponentes.ui.screens.menu.MenuScreen
import com.kiko.kikocomponentes.ui.screens.navigation.NavigationBarScreen
import com.kiko.kikocomponentes.ui.screens.outlined.OutlinedScreen
import com.kiko.kikocomponentes.ui.screens.radiobutton.RadioButtonScreen
import com.kiko.kikocomponentes.ui.screens.search.SearchScreen
import com.kiko.kikocomponentes.ui.screens.sheets.BottomSheetScreen
import com.kiko.kikocomponentes.ui.screens.sheets.SideSheetScreen
import com.kiko.kikocomponentes.ui.screens.slider.SliderScreen
import com.kiko.kikocomponentes.ui.screens.snackbar.SnackBarScreen
import com.kiko.kikocomponentes.ui.screens.splash.SplashScreen
import com.kiko.kikocomponentes.ui.screens.`switch`.SwitchScreen
import com.kiko.kikocomponentes.ui.screens.tabs.TabsScreen
import com.kiko.kikocomponentes.ui.screens.toast.ToastScreen
import com.kiko.kikocomponentes.ui.screens.toolsbar.ToolsBarScreen
import com.kiko.kikocomponentes.ui.screens.tooltips.ToolTipsScreen
import com.kiko.kikocomponentes.viewmodel.ThemeViewModel

@Composable
fun AppNavigation(themeViewModel: ThemeViewModel) {
    val navController = rememberNavController()
    val themeType by themeViewModel.themeType.collectAsState()
    val isDarkMode by themeViewModel.isDarkMode.collectAsState()

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
                },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }

        // --- Componentes ---
        composable(Screen.AlertDialog.route) {
            AlertDialogScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Badges.route) {
            BadgeScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Cards.route) {
            CardsScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Carousel.route) {
            CarouselScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Checkbox.route) {
            CheckboxScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Chips.route) {
            ChipsScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Dividers.route) {
            DividerScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Lists.route) {
            ListScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Loading.route) {
            LoadingScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Menus.route) {
            MenuScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.NavigationBar.route) {
            NavigationBarScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Outlined.route) {
            OutlinedScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.RadioButton.route) {
            RadioButtonScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Search.route) {
            SearchScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Slider.route) {
            SliderScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Snackbar.route) {
            SnackBarScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Switch.route) {
            SwitchScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Tabs.route) {
            TabsScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.ToolsBar.route) {
            ToolsBarScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Tooltips.route) {
            ToolTipsScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.Toast.route) {
            ToastScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }

        // --- Sheets ---
        composable(Screen.SheetsBottom.route) {
            BottomSheetScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.SheetsSide.route) {
            SideSheetScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }

        // --- Date & Time ---
        composable(Screen.DateTime.route + "_date") {
            DatePickerScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.DateTime.route + "_time") {
            TimePickerScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }

        // --- Telas de Buttons ---
        composable(Screen.ButtonsStandard.route) {
            ButtonsScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.ButtonsFab.route) {
            FabScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.ButtonsIcon.route) {
            IconButtonScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.ButtonsSplit.route) {
            SplitButtonScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.ButtonsGroups.route) {
            ButtonGroupsScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }

        // --- Telas de App Bars ---
        composable(Screen.AppBarsBottom.route) {
            BottomBarScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.AppBarsSmall.route) {
            SmallTopBarScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.AppBarsCenter.route) {
            CenterTopBarScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.AppBarsMedium.route) {
            MediumTopBarScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
        composable(Screen.AppBarsLarge.route) {
            LargeTopBarScreen(
                onBack = { navController.popBackStack() },
                isDarkTheme = isDarkMode,
                onDarkModeChange = { themeViewModel.setDarkMode(it) },
                selectedTheme = themeType,
                onThemeTypeChange = { themeViewModel.setTheme(it) }
            )
        }
    }
}
