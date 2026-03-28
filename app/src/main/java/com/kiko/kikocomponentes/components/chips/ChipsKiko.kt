package com.kiko.kikocomponentes.components.chips

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme


@Composable
fun AssistChipKiko() {
    AssistChip(
        onClick = { Log.d("Assist chip", "hello world") },
        label = {
            Text(
                text = "Assist chip",
                color = MaterialTheme.colorScheme.tertiary
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Localized description",
                modifier = Modifier.size(AssistChipDefaults.IconSize),
                tint = MaterialTheme.colorScheme.tertiary
            )
        },
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.tertiary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipKiko() {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(
                text = "Filter chip",
                color = if (selected) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.tertiary
            )
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = if (selected) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.tertiary
                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.tertiary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChipKiko(
    text: String = "Input chip",
    onDismiss: () -> Unit = {}
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = {
            Text(
                text = text,
                color = if (enabled) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.tertiary
            )
        },
        selected = enabled,
        avatar = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Localized description",
                modifier = Modifier.size(InputChipDefaults.AvatarSize),
                tint = if (enabled) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.tertiary
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Localized description",
                modifier = Modifier.size(InputChipDefaults.AvatarSize),
                tint = if (enabled) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.tertiary
            )
        },
        colors = InputChipDefaults.inputChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.tertiary
        )
    )
}
@Composable
fun ChipsScreenKiko() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AssistChipKiko()
        FilterChipKiko()
        InputChipKiko()
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Chips Light")
@Composable
fun PreviewChipsLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            ChipsScreenKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Chips Dark")
@Composable
fun PreviewChipsDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            ChipsScreenKiko()
        }
    }
}
