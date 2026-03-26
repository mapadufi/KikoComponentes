package com.kiko.kikocomponentes.components.`switch`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kofre.ui.theme.KikoComponentesTheme

@Composable
fun SwitchKiko(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.tertiary,
            checkedTrackColor = MaterialTheme.colorScheme.tertiaryContainer,
            checkedIconColor = MaterialTheme.colorScheme.tertiaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.tertiary,
            uncheckedTrackColor = MaterialTheme.colorScheme.tertiaryContainer,
            uncheckedIconColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    )
}

@Composable
fun SwitchScreenKiko() {
    var checked1 by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Interruptores",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Ativado", color = MaterialTheme.colorScheme.onSurface)
            SwitchKiko(checked = checked1, onCheckedChange = { checked1 = it })
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Desativado", color = MaterialTheme.colorScheme.onSurface)
            SwitchKiko(checked = checked2, onCheckedChange = { checked2 = it })
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Switch Light")
@Composable
fun PreviewSwitchLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            SwitchScreenKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Switch Dark")
@Composable
fun PreviewSwitchDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            SwitchScreenKiko()
        }
    }
}
