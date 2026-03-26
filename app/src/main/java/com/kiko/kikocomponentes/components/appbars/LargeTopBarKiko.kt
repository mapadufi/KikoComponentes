package com.kiko.kikocomponentes.components.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.kiko.kofre.ui.theme.KikoComponentesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopBarKiko(scrollBehavior: TopAppBarScrollBehavior? = null) {
    LargeTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            titleContentColor = MaterialTheme.colorScheme.tertiaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.tertiaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.tertiaryContainer
        ),
        title = {
            Text(
                "Large Top App Bar",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
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
        },
        scrollBehavior = scrollBehavior
    )
}

//===================================================
// Preview Ligth
//===================================================
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LargeTopBarKikoPreview() {
    KikoComponentesTheme {
        LargeTopBarKiko()
    }
}

//===================================================
// Preview Dark
//===================================================
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "LargeTopAppBar Dark")
@Composable
fun LargeTopBarKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        LargeTopBarKiko()
    }
}
