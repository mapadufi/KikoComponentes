package com.kiko.kikocomponentes.components.datetime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerKiko() {
    val state = rememberTimePickerState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        TimePicker(
            state = state,
            colors = getTimePickerKikoColors()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeInputKiko() {
    val state = rememberTimePickerState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        TimeInput(
            state = state,
            colors = getTimePickerKikoColors()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerFieldToModalKiko() {
    var selectedTime by remember { mutableStateOf<String?>(null) }
    var showModal by remember { mutableStateOf(false) }
    val state = rememberTimePickerState()

    OutlinedTextField(
        value = selectedTime ?: "",
        onValueChange = { },
        label = { Text("Horário", color = MaterialTheme.colorScheme.tertiary) },
        readOnly = true,
        trailingIcon = {
            IconButton(onClick = { showModal = true }) {
                Icon(
                    imageVector = Icons.Default.AccessTime,
                    contentDescription = "Selecionar horário",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.tertiary,
            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
        ),
        modifier = Modifier.fillMaxWidth()
    )

    if (showModal) {
        TimePickerDialogKiko(
            onDismiss = { showModal = false },
            onConfirm = {
                selectedTime = String.format("%02d:%02d", state.hour, state.minute)
                showModal = false
            }
        ) {
            TimePicker(state = state, colors = getTimePickerKikoColors())
        }
    }
}

@Composable
fun TimePickerDialogKiko(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar", color = MaterialTheme.colorScheme.tertiary)
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("OK", color = MaterialTheme.colorScheme.tertiary)
            }
        },
        text = {
            content()
        },
        containerColor = MaterialTheme.colorScheme.tertiaryContainer
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getTimePickerKikoColors() = TimePickerDefaults.colors(
    clockDialColor = MaterialTheme.colorScheme.tertiaryContainer,
    clockDialSelectedContentColor = MaterialTheme.colorScheme.tertiaryContainer,
    clockDialUnselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
    selectorColor = MaterialTheme.colorScheme.tertiary,
    periodSelectorBorderColor = MaterialTheme.colorScheme.tertiary,
    periodSelectorSelectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
    periodSelectorUnselectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
    periodSelectorSelectedContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
    periodSelectorUnselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
    timeSelectorSelectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
    timeSelectorUnselectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
    timeSelectorSelectedContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
    timeSelectorUnselectedContentColor = MaterialTheme.colorScheme.onTertiaryContainer
)

@Composable
fun TimePickerScreenKiko() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("TimePicker Field", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.tertiary)
        TimePickerFieldToModalKiko()

        Text("TimePicker Inline", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.tertiary)
        TimePickerKiko()

        Text("TimeInput Inline", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.tertiary)
        TimeInputKiko()
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "TimePicker Light")
@Composable
fun TimePickerKikoPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            TimePickerScreenKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "TimePicker Dark")
@Composable
fun TimePickerKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            TimePickerScreenKiko()
        }
    }
}
