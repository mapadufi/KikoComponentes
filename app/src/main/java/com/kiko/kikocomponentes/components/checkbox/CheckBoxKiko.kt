package com.kiko.kikocomponentes.components.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.divider.HorizontalDividerKiko
import com.kiko.kofre.ui.theme.KikoComponentesTheme

@Composable
fun SimpleCheckboxKiko(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .toggleable(
                value = checked,
                onValueChange = { onCheckedChange(!checked) },
                role = Role.Checkbox
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.tertiary,
                checkmarkColor = MaterialTheme.colorScheme.onTertiary
            )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp),
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun MultiSelectCheckboxKiko() {
    val items = listOf("Opção 1", "Opção 2", "Opção 3")
    val selectedItems = remember { mutableStateListOf<String>() }

    Column {
        items.forEach { item ->
            val isChecked = selectedItems.contains(item)
            SimpleCheckboxKiko(
                label = item,
                checked = isChecked,
                onCheckedChange = {
                    if (isChecked) selectedItems.remove(item) else selectedItems.add(item)
                }
            )
        }
    }
}

@Composable
fun SelectAllCheckboxKiko() {
    val options = listOf("Sub-item 1", "Sub-item 2", "Sub-item 3")
    val checkedStates = remember { mutableStateListOf(false, false, false) }

    // Define o estado do checkbox "Marcar Todos"
    val parentState = remember(checkedStates.toList()) {
        if (checkedStates.all { it }) ToggleableState.On
        else if (checkedStates.all { !it }) ToggleableState.Off
        else ToggleableState.Indeterminate
    }

    val onParentClick = {
        val newState = parentState != ToggleableState.On
        for (i in checkedStates.indices) {
            checkedStates[i] = newState
        }
    }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .toggleable(
                    value = parentState == ToggleableState.On,
                    onValueChange = { onParentClick() },
                    role = Role.Checkbox
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TriStateCheckbox(
                state = parentState,
                onClick = null,
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.tertiary,
                    checkmarkColor = MaterialTheme.colorScheme.onTertiary
                )
            )
            Text(
                text = "Marcar Todos",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
        }

        options.forEachIndexed { index, option ->
            SimpleCheckboxKiko(
                label = option,
                checked = checkedStates[index],
                onCheckedChange = { isChecked -> checkedStates[index] = isChecked },
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}

@Composable
fun CheckboxScreenKiko() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        var checked by remember { mutableStateOf(false) }
        
        Text(
            text = "Checkbox Simples",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        SimpleCheckboxKiko(
            label = "Aceito os termos",
            checked = checked,
            onCheckedChange = { checked = it }
        )
        
        HorizontalDividerKiko(modifier = Modifier.padding(vertical = 16.dp))
        
        Text(
            text = "Checkbox Multi-seleção",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        MultiSelectCheckboxKiko()

        HorizontalDividerKiko(modifier = Modifier.padding(vertical = 16.dp))
        
        Text(
            text = "Checkbox Marcar Todos",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        SelectAllCheckboxKiko()
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Checkbox Light")
@Composable
fun PreviewCheckboxLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            CheckboxScreenKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Checkbox Dark")
@Composable
fun PreviewCheckboxDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            CheckboxScreenKiko()
        }
    }
}
