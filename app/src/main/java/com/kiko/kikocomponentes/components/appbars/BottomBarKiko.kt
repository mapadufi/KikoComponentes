package com.kiko.kikocomponentes.components.appbars

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme


@Composable
fun BottomBarKiko() {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.tertiaryContainer,
        actions = {
            IconButton(onClick = { /* ação */ }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check"
                )
            }
            IconButton(onClick = { /* ação */ }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit"
                )
            }
            IconButton(onClick = { /* ação */ }) {
                Icon(
                    imageVector = Icons.Filled.Mic,
                    contentDescription = "Mic"
                )
            }
            IconButton(onClick = { /* ação */ }) {
                Icon(
                    imageVector = Icons.Filled.Image,
                    contentDescription = "Image"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* ação */ },
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.tertiary,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add"
                )
            }
        }
    )
}

//===================================================
// Preview Ligth
//===================================================
@Preview(showBackground = true)
@Composable
fun BottomBarKikoPreview() {
    KikoComponentesTheme {
        BottomBarKiko()
    }
}

//===================================================
// Preview Dark
//===================================================
@Preview(showBackground = true, name = "BottomAppBar Dark")
@Composable
fun BottomBarKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        BottomBarKiko()
    }
}
