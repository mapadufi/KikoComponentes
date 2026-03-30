package com.kiko.kikocomponentes.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

// Largura padrão para todos os botões seguindo o KikoExtraButton
private val DefaultButtonWidth = 280.dp

@Composable
fun FilledButtonKiko(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = modifier.width(DefaultButtonWidth),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Text("Filled")
    }
}

@Composable
fun FilledTonalButtonKiko(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier.width(DefaultButtonWidth),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Text("Tonal")
    }
}

@Composable
fun OutlinedButtonKiko(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.width(DefaultButtonWidth),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.tertiary
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary)
    ) {
        Text("Outlined")
    }
}

@Composable
fun TextButtonKiko(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    TextButton(
        onClick = onClick,
        modifier = modifier.width(DefaultButtonWidth),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Text("Text Button")
    }
}

@Composable
fun KikoExtraButton(
    modifier: Modifier = Modifier,
    text: String = "Extra",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier.width(DefaultButtonWidth),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f),
            contentColor = MaterialTheme.colorScheme.primary
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun PersonButtonKiko(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Box(
        modifier = modifier
            .width(DefaultButtonWidth)
            .height(40.dp)
            .clickable(onClick = onClick)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF003399),
                        Color(0xFF0787FF)
                    )
                ),
                shape = RoundedCornerShape(25.dp)
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Person",
            color = Color.White
        )
    }
}

@Composable
fun ButtonColumnKiko() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilledButtonKiko()
            FilledTonalButtonKiko()
            OutlinedButtonKiko()
            TextButtonKiko()
            KikoExtraButton()
            PersonButtonKiko()
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Buttons Light")
@Composable
fun ButtonColumnKikoPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            ButtonColumnKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Buttons Dark")
@Composable
fun ButtonColumnKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            ButtonColumnKiko()
        }
    }
}
