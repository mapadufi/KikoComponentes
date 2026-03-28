package com.kiko.kikocomponentes.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ButtonGroupsKiko(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(modifier = Modifier.padding(16.dp)) {
        options.forEachIndexed { index, option ->
            val shape = when (index) {
                0 -> RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                options.size - 1 -> RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                else -> RectangleShape
            }

            val isSelected = option == selectedOption

            OutlinedButton(
                onClick = { onOptionSelected(option) },
                shape = shape,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (isSelected) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = if (isSelected) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.onTertiaryContainer
                ),
                modifier = Modifier.padding(0.dp)
            ) {
                Text(option)
            }
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "ButtonGroups Light")
@Composable
fun PreviewButtonGroupsLight() {
    KikoComponentesTheme (darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            ButtonGroupsKiko(
                options = listOf("Opção 1", "Opção 2", "Opção 3"),
                selectedOption = "Opção 1",
                onOptionSelected = {}
            )
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "ButtonGroups Dark")
@Composable
fun PreviewButtonGroupsDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            ButtonGroupsKiko(
                options = listOf("Opção 1", "Opção 2", "Opção 3"),
                selectedOption = "Opção 1",
                onOptionSelected = {}
            )
        }
    }
}
