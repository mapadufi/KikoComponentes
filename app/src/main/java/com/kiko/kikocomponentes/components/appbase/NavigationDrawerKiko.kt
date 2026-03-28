package com.kiko.kikocomponentes.components.appbase

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.MenuOpen
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.divider.HorizontalDividerKiko
import com.kiko.kikocomponentes.navigation.Screen
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

data class KikoDrawerItem(
    val label: String,
    val icon: ImageVector,
    val route: String? = null,
    val subItems: List<KikoDrawerItem>? = null
)

@Composable
fun NavigationDrawerKiko(
    selectedRoute: String = "",
    onItemClick: (String) -> Unit = {},
    onLogoutClick: () -> Unit = {},
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    content: @Composable () -> Unit
) {
    val expandedStates = remember { mutableStateMapOf<String, Boolean>() }

    val items = listOf(
        KikoDrawerItem("Início", Icons.Default.Home, Screen.Main.route),
        KikoDrawerItem("Alert Dialog", Icons.Default.Warning, Screen.AlertDialog.route),
        KikoDrawerItem("App Bars", Icons.Default.HorizontalSplit, subItems = listOf(
            KikoDrawerItem("Bottom Bar", Icons.Default.HorizontalSplit, Screen.AppBars.route + "_bottom"),
            KikoDrawerItem("Small Top Bar", Icons.Default.HorizontalSplit, Screen.AppBars.route + "_small"),
            KikoDrawerItem("Center Top Bar", Icons.Default.HorizontalSplit, Screen.AppBars.route + "_center"),
            KikoDrawerItem("Medium Top Bar", Icons.Default.HorizontalSplit, Screen.AppBars.route + "_medium"),
            KikoDrawerItem("Large Top Bar", Icons.Default.HorizontalSplit, Screen.AppBars.route + "_large")
        )),
        KikoDrawerItem("Badges", Icons.Default.Notifications, Screen.Badges.route),
        KikoDrawerItem("Buttons", Icons.Default.SmartButton, subItems = listOf(
            KikoDrawerItem("Standard Buttons", Icons.Default.SmartButton, Screen.Buttons.route),
            KikoDrawerItem("Groups", Icons.Default.GroupWork, Screen.Buttons.route + "_groups"),
            KikoDrawerItem("Segmented", Icons.Default.ViewArray, Screen.Buttons.route + "_segmented"),
            KikoDrawerItem("Fab", Icons.Default.Add, Screen.Buttons.route + "_fab")
        )),
        KikoDrawerItem("Cards", Icons.Default.CreditCard, Screen.Cards.route),
        KikoDrawerItem("Carousel", Icons.Default.ViewCarousel, Screen.Carousel.route),
        KikoDrawerItem("Checkbox", Icons.Default.CheckBox, Screen.Checkbox.route),
        KikoDrawerItem("Chips", Icons.AutoMirrored.Filled.Label, Screen.Chips.route),
        KikoDrawerItem("Date & Time", Icons.Default.Event, subItems = listOf(
            KikoDrawerItem("Date Picker", Icons.Default.DateRange, Screen.DateTime.route + "_date"),
            KikoDrawerItem("Time Picker", Icons.Default.AccessTime, Screen.DateTime.route + "_time")
        )),
        KikoDrawerItem("Dividers", Icons.Default.HorizontalRule, Screen.Dividers.route),
        KikoDrawerItem("Lists", Icons.AutoMirrored.Filled.List, Screen.Lists.route),
        KikoDrawerItem("Loading", Icons.Default.Refresh, subItems = listOf(
            KikoDrawerItem("Circular/Linear", Icons.Default.Refresh, Screen.Loading.route),
            KikoDrawerItem("Expressive", Icons.Default.Star, Screen.Loading.route + "_expressive")
        )),
        KikoDrawerItem("Menus", Icons.AutoMirrored.Filled.MenuOpen, Screen.Menus.route),
        KikoDrawerItem("Navigation Bar", Icons.Default.Menu, Screen.NavigationBar.route),
        KikoDrawerItem("Outlined Fields", Icons.Default.TextFields, Screen.Outlined.route),
        KikoDrawerItem("Radio Button", Icons.Default.RadioButtonChecked, Screen.RadioButton.route),
        KikoDrawerItem("Search", Icons.Default.Search, Screen.Search.route),
        KikoDrawerItem("Sheets", Icons.Default.Layers, subItems = listOf(
            KikoDrawerItem("Bottom Sheet", Icons.Default.ExpandMore, Screen.Sheets.route + "_bottom"),
            KikoDrawerItem("Side Sheet", Icons.Default.SubdirectoryArrowRight, Screen.Sheets.route + "_side")
        )),
        KikoDrawerItem("Slider", Icons.Default.LinearScale, Screen.Slider.route),
        KikoDrawerItem("Snackbar", Icons.Default.Info, Screen.Snackbar.route),
        KikoDrawerItem("Switch", Icons.Default.ToggleOn, Screen.Switch.route),
        KikoDrawerItem("Tabs", Icons.Default.Tab, subItems = listOf(
            KikoDrawerItem("Primary Tabs", Icons.Default.Tab, Screen.Tabs.route + "_primary"),
            KikoDrawerItem("Secondary Tabs", Icons.Default.TabUnselected, Screen.Tabs.route + "_secondary")
        )),
        KikoDrawerItem("Tools Bar", Icons.Default.Build, Screen.ToolsBar.route),
        KikoDrawerItem("Tooltips", Icons.Default.QuestionMark, subItems = listOf(
            KikoDrawerItem("Plain Tooltip", Icons.Default.QuestionMark, Screen.Tooltips.route + "_plain"),
            KikoDrawerItem("Rich Tooltip", Icons.Default.Lightbulb, Screen.Tooltips.route + "_rich")
        ))
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.surface,
                drawerContentColor = MaterialTheme.colorScheme.onSurface
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    // Header com fundo Tertiary e Texto em TertiaryContainer
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.tertiary)
                            .padding(vertical = 32.dp, horizontal = 24.dp)
                    ) {
                        Text(
                            text = "Kiko Componentes",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.tertiaryContainer
                        )
                    }
                    
                    Spacer(Modifier.height(8.dp))
                    
                    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                        items.forEach { item ->
                            val hasSubItems = !item.subItems.isNullOrEmpty()
                            val isExpanded = expandedStates[item.label] ?: false

                            NavigationDrawerItem(
                                label = { Text(item.label) },
                                selected = item.route == selectedRoute,
                                onClick = {
                                    if (hasSubItems) {
                                        expandedStates[item.label] = !isExpanded
                                    } else {
                                        item.route?.let { onItemClick(it) }
                                    }
                                },
                                icon = { Icon(item.icon, contentDescription = null) },
                                badge = {
                                    if (hasSubItems) {
                                        Icon(
                                            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                            contentDescription = null
                                        )
                                    }
                                },
                                shape = MaterialTheme.shapes.medium,
                                colors = NavigationDrawerItemDefaults.colors(
                                    selectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                                    unselectedIconColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.7f),
                                    unselectedTextColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.7f)
                                ),
                                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                            )

                            if (hasSubItems) {
                                AnimatedVisibility(visible = isExpanded) {
                                    Column(modifier = Modifier.padding(start = 24.dp)) {
                                        item.subItems?.forEach { subItem ->
                                            NavigationDrawerItem(
                                                label = { Text(subItem.label, style = MaterialTheme.typography.bodyMedium) },
                                                selected = subItem.route == selectedRoute,
                                                onClick = { subItem.route?.let { onItemClick(it) } },
                                                icon = { Icon(subItem.icon, contentDescription = null, modifier = Modifier.size(18.dp)) },
                                                shape = MaterialTheme.shapes.medium,
                                                colors = NavigationDrawerItemDefaults.colors(
                                                    selectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.5f),
                                                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                                                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                                                    unselectedIconColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
                                                    unselectedTextColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f)
                                                ),
                                                modifier = Modifier.padding(vertical = 2.dp).padding(NavigationDrawerItemDefaults.ItemPadding)
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // Divider e Item Sair
                        Spacer(Modifier.height(8.dp))
                        HorizontalDividerKiko(modifier = Modifier.padding(horizontal = 12.dp))
                        Spacer(Modifier.height(8.dp))

                        NavigationDrawerItem(
                            label = { Text("Sair") },
                            selected = false,
                            onClick = onLogoutClick,
                            icon = { Icon(Icons.Default.ExitToApp, contentDescription = null) },
                            shape = MaterialTheme.shapes.medium,
                            colors = NavigationDrawerItemDefaults.colors(
                                unselectedIconColor = MaterialTheme.colorScheme.error,
                                unselectedTextColor = MaterialTheme.colorScheme.error
                            ),
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                }
            }
        },
        content = content
    )
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, name = "Drawer Light")
@Composable
fun NavigationDrawerKikoPreviewLight() {
    KikoComponentesTheme (darkTheme = false) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
        NavigationDrawerKiko(
            drawerState = drawerState
        ) {
            Box(Modifier.fillMaxSize())
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, name = "Drawer Dark")
@Composable
fun NavigationDrawerKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
        NavigationDrawerKiko(
            drawerState = drawerState
        ) {
            Box(Modifier.fillMaxSize())
        }
    }
}
