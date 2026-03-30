package com.kiko.kikocomponentes.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Main : Screen("main")
    object AlertDialog : Screen("alert_dialog")
    object Badges : Screen("badges")
    
    // App Bars
    object AppBarsBottom : Screen("app_bars_bottom")
    object AppBarsSmall : Screen("app_bars_small")
    object AppBarsCenter : Screen("app_bars_center")
    object AppBarsMedium : Screen("app_bars_medium")
    object AppBarsLarge : Screen("app_bars_large")

    // Buttons
    object ButtonsStandard : Screen("buttons_standard")
    object ButtonsFab : Screen("buttons_fab")
    object ButtonsIcon : Screen("buttons_icon")
    object ButtonsSplit : Screen("buttons_split")
    object ButtonsGroups : Screen("buttons_groups")
    object ButtonsSegmented : Screen("buttons_segmented")

    // Sheets
    object SheetsBottom : Screen("sheets_bottom")
    object SheetsSide : Screen("sheets_side")

    // Tabs
    object Tabs : Screen("tabs")
    object TabsPrimary : Screen("tabs_primary")
    object TabsSecondary : Screen("tabs_secondary")

    // Tooltips
    object Tooltips : Screen("tooltips")
    object TooltipsPlain : Screen("tooltips_plain")
    object TooltipsRich : Screen("tooltips_rich")

    object Cards : Screen("cards")
    object Carousel : Screen("carousel")
    object Checkbox : Screen("checkbox")
    object Chips : Screen("chips")
    object DateTime : Screen("datetime")
    object Dividers : Screen("dividers")
    object Lists : Screen("lists")
    object Loading : Screen("loading")
    object Menus : Screen("menus")
    object NavigationBar : Screen("navigation_bar")
    object Outlined : Screen("outlined")
    object RadioButton : Screen("radio")
    object Search : Screen("search")
    object Slider : Screen("slider")
    object Snackbar : Screen("snackbar")
    object Switch : Screen("switch")
    object ToolsBar : Screen("tools_bar")
    object Toast : Screen("toast")
}
