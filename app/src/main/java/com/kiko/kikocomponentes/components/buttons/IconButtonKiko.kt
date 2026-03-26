package com.kiko.kikocomponentes.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kofre.ui.theme.KikoComponentesTheme

// ==============================
// Icon Button Básico (toggle)
// ==============================
@Composable
fun IconButtonBasicKiko(
    initialState: Boolean = false,
    onToggle: ((Boolean) -> Unit)? = null
) {
    var isToggled by rememberSaveable { mutableStateOf(initialState) }

    IconButton(
        onClick = {
            isToggled = !isToggled
            onToggle?.invoke(isToggled)
        }
    ) {
        val icon = if (isToggled) Icons.Filled.Favorite else Icons.Filled.Person
        val description = if (isToggled) "Favorito" else "Pessoa"

        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
}


// ==============================
// Icon Button Person Kiko
// (Seletor numérico com setas dupla, cor primary)
// ==============================
@Composable
fun IconButtonPersonKiko(
    modifier: Modifier = Modifier,
    value: Int,
    range: IntRange = Int.MIN_VALUE..Int.MAX_VALUE,
    onValueChange: (Int) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = modifier.graphicsLayer {
            scaleX = if (isPressed) 0.95f else 1f
            scaleY = if (isPressed) 0.95f else 1f
            alpha = if (isPressed) 0.8f else 1f
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Botão diminuir
            IconButton(onClick = {
                if (value > range.first) onValueChange(value - 1)
            }) {
                Icon(
                    Icons.Filled.KeyboardDoubleArrowLeft,
                    contentDescription = "Diminuir",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }

            // Texto central
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.clickable {
                    // opcional: ação ao clicar no número
                }
            )

            // Botão aumentar
            IconButton(onClick = {
                if (value < range.last) onValueChange(value + 1)
            }) {
                Icon(
                    Icons.Filled.KeyboardDoubleArrowRight,
                    contentDescription = "Aumentar",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Icon Buttons Light Mode")
@Composable
fun PreviewIconButtonsLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            var number by remember { mutableStateOf(5) }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                IconButtonBasicKiko {  }

                IconButtonPersonKiko(
                    value = number,
                    range = 0..10,
                    onValueChange = { number = it }
                )
            }
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Icon Buttons Dark Mode")
@Composable
fun PreviewIconButtonsDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            var number by remember { mutableStateOf(5) }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                IconButtonBasicKiko {  }

                IconButtonPersonKiko(
                    value = number,
                    range = 0..10,
                    onValueChange = { number = it }
                )
            }
        }
    }
}
