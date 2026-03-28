package com.kiko.kikocomponentes.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme


@Composable
fun FabSmallKiko(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.tertiaryContainer
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Adicionar")
    }
}

@Composable
fun FabLargeKiko(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.tertiaryContainer
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Adicionar")
    }
}

@Composable
fun FabExtendedKiko(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = { Icon(Icons.Filled.Add, contentDescription = "Adicionar") },
        text = { Text(text = "Extended FAB") },
        containerColor = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.tertiaryContainer
    )
}
@Composable
fun FabSmallPersonKiko() {
    var expanded by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp) // distância do topo da coluna
    ) {
        // Mostrar os Extended FABs apenas quando expandido
        if (expanded) {
            ExtendedFloatingActionButton(
                onClick = { /* ação Teste 1 */ },
                icon = { Icon(Icons.Filled.Star, contentDescription = "Teste 1") },
                text = { Text("Teste 1") },
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.tertiaryContainer
            )
            ExtendedFloatingActionButton(
                onClick = { /* ação Teste 2 */ },
                icon = { Icon(Icons.Filled.Favorite, contentDescription = "Teste 2") },
                text = { Text("Teste 2") },
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.tertiaryContainer
            )
        }

        // FAB principal
        SmallFloatingActionButton(
            onClick = { expanded = !expanded },
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.tertiaryContainer
        ) {
            Icon(Icons.Filled.Person, contentDescription = "Principal")
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "All FABs Light")
@Composable
fun PreviewAllFabsLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                FabSmallKiko(onClick = {})
                FabLargeKiko(onClick = {})
                FabExtendedKiko(onClick = {})

                Spacer(modifier = Modifier.height(32.dp))

                FabSmallPersonKiko()
            }
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "All FABs Dark")
@Composable
fun PreviewAllFabsDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                FabSmallKiko(onClick = {})
                FabLargeKiko(onClick = {})
                FabExtendedKiko(onClick = {})

                Spacer(modifier = Modifier.height(32.dp))

                FabSmallPersonKiko()
            }
        }
    }
}
