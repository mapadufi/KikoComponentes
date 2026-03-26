package com.kiko.kikocomponentes.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kofre.ui.theme.KikoComponentesTheme

@Composable
fun PrimaryTabsKiko(
    modifier: Modifier = Modifier
) {
    var state by remember { mutableIntStateOf(0) }
    val titles = listOf("Início", "Favoritos", "Perfil")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Person)

    PrimaryTabRow(
        selectedTabIndex = state,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.tertiary,
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                modifier = Modifier.tabIndicatorOffset(state),
                width = 64.dp, // Largura personalizada para o indicador expressivo
                color = MaterialTheme.colorScheme.tertiary,
                shape = MaterialTheme.shapes.medium
            )
        },
        divider = {}
    ) {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = state == index,
                onClick = { state = index },
                text = {
                    Text(
                        text = title,
                        color = if (state == index) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = null,
                        tint = if (state == index) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            )
        }
    }
}

@Composable
fun SecondaryTabsKiko(
    modifier: Modifier = Modifier
) {
    var state by remember { mutableIntStateOf(0) }
    val titles = listOf("Opção 1", "Opção 2", "Opção 3")

    SecondaryTabRow(
        selectedTabIndex = state,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.tertiary,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(state),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    ) {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = state == index,
                onClick = { state = index },
                text = {
                    Text(
                        text = title,
                        color = if (state == index) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            )
        }
    }
}

@Composable
fun TabsScreenKiko() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Primary Tab Row",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        PrimaryTabsKiko()

        Text(
            text = "Secondary Tab Row",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        SecondaryTabsKiko()
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Tabs Light")
@Composable
fun PreviewTabsLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            TabsScreenKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Tabs Dark")
@Composable
fun PreviewTabsDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            TabsScreenKiko()
        }
    }
}
