package com.kiko.kikocomponentes.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

// ==============================
// Single Choice Segmented Button (original)
// ==============================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleSegmentedButtonKiko(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Day", "Month", "Week")

    SingleChoiceSegmentedButtonRow(modifier = modifier) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) },
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = MaterialTheme.colorScheme.tertiary,
                    activeContentColor = MaterialTheme.colorScheme.tertiaryContainer,
                    activeBorderColor = MaterialTheme.colorScheme.tertiary,
                    inactiveContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    inactiveContentColor = MaterialTheme.colorScheme.tertiary,
                    inactiveBorderColor = MaterialTheme.colorScheme.tertiary
                )
            )
        }
    }
}

// ==============================
// Multi Choice Segmented Button
// ==============================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiChoiceSegmentedButton(modifier: Modifier = Modifier) {
    val selectedOptions = remember { mutableStateListOf(false, false, false) }
    val options = listOf("Walk", "Ride", "Drive")

    MultiChoiceSegmentedButtonRow(modifier = modifier.padding(top = 32.dp)) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                checked = selectedOptions[index],
                onCheckedChange = { selectedOptions[index] = !selectedOptions[index] },
                icon = { SegmentedButtonDefaults.Icon(selectedOptions[index]) },
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = MaterialTheme.colorScheme.tertiary,
                    activeContentColor = MaterialTheme.colorScheme.tertiaryContainer,
                    activeBorderColor = MaterialTheme.colorScheme.tertiary,
                    inactiveContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    inactiveContentColor = MaterialTheme.colorScheme.tertiary,
                    inactiveBorderColor = MaterialTheme.colorScheme.tertiary
                ),
                label = {
                    when (label) {
                        "Walk" -> Icon(
                            imageVector = Icons.Filled.DirectionsWalk,
                            contentDescription = "Walk"
                        )
                        "Ride" -> Icon(
                            imageVector = Icons.Filled.DirectionsBus,
                            contentDescription = "Ride"
                        )
                        "Drive" -> Icon(
                            imageVector = Icons.Filled.DirectionsCar,
                            contentDescription = "Drive"
                        )
                    }
                }
            )
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Segmented Buttons Light")
@Composable
fun PreviewSegmentedButtonsLight() {
    KikoComponentesTheme (darkTheme = false) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleSegmentedButtonKiko(
                modifier = Modifier.padding(top = 50.dp)
            )
            MultiChoiceSegmentedButton()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Segmented Buttons Dark")
@Composable
fun PreviewSegmentedButtonsDark() {
    KikoComponentesTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleSegmentedButtonKiko(
                modifier = Modifier.padding(top = 50.dp)
            )
            MultiChoiceSegmentedButton()
        }
    }
}
