package com.kiko.kikocomponentes.components.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kiko.kofre.ui.theme.KikoComponentesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopBarKiko() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            titleContentColor = MaterialTheme.colorScheme.tertiaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.tertiaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.tertiaryContainer
        ),
        title = {
            Text("Small Top App Bar")
        },
        navigationIcon = {
            IconButton(onClick = { /* ação */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* ação */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        }
    )
}

//===================================================
// Preview Ligth
//===================================================
@Preview(showBackground = true, name = "SmallTopAppBar Light")
@Composable
fun SmallTopBarKikoPreview() {
    KikoComponentesTheme {
        SmallTopBarKiko()
    }
}

//===================================================
// Preview Dark
//===================================================
@Preview(showBackground = true, name = "SmallTopAppBar Dark")
@Composable
fun SmallTopBarKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        SmallTopBarKiko()
    }
}
