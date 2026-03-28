package com.kiko.kikocomponentes.components.toolsbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ToolsBarKiko(
    modifier: Modifier = Modifier,
    onCheckClick: () -> Unit = {},
    onEditClick: () -> Unit = {},
    onMicClick: () -> Unit = {},
    onImageClick: () -> Unit = {},
    onFabClick: () -> Unit = {}
) {
    BottomAppBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.tertiary,
        tonalElevation = 8.dp,
        actions = {
            IconButton(onClick = onCheckClick) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
            IconButton(onClick = onEditClick) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
            IconButton(onClick = onMicClick) {
                Icon(
                    imageVector = Icons.Filled.Mic,
                    contentDescription = "Mic",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
            IconButton(onClick = onImageClick) {
                Icon(
                    imageVector = Icons.Filled.Image,
                    contentDescription = "Image",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFabClick,
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.tertiaryContainer,
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

@Composable
fun ToolsBarScreenKiko() {
    Scaffold(
        bottomBar = {
            ToolsBarKiko()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Conteúdo com Barra de Ferramentas",
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "ToolsBar Light")
@Composable
fun PreviewToolsBarLight() {
    KikoComponentesTheme(darkTheme = false) {
        ToolsBarScreenKiko()
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "ToolsBar Dark")
@Composable
fun PreviewToolsBarDark() {
    KikoComponentesTheme(darkTheme = true) {
        ToolsBarScreenKiko()
    }
}
