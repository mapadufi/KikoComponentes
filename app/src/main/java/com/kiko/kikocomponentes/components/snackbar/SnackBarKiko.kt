package com.kiko.kikocomponentes.components.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun SnackBarKiko(
    snackbarData: SnackbarData,
    modifier: Modifier = Modifier
) {
    Snackbar(
        modifier = modifier.padding(12.dp),
        action = {
            snackbarData.visuals.actionLabel?.let { actionLabel ->
                TextButton(
                    onClick = { snackbarData.performAction() }
                ) {
                    Text(
                        text = actionLabel,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = snackbarData.visuals.message)
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "SnackBar Light")
@Composable
fun SnackBarKikoPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.BottomCenter
        ) {
            // Mock data para o preview
            val mockData = object : SnackbarData {
                override val visuals = object : SnackbarVisuals {
                    override val message: String = "Esta é uma mensagem de alerta!"
                    override val actionLabel: String = "OK"
                    override val withDismissAction: Boolean = false
                    override val duration: SnackbarDuration = SnackbarDuration.Short
                }
                override fun performAction() {}
                override fun dismiss() {}
            }
            SnackBarKiko(snackbarData = mockData)
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "SnackBar Dark")
@Composable
fun SnackBarKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.BottomCenter
        ) {
            val mockData = object : SnackbarData {
                override val visuals = object : SnackbarVisuals {
                    override val message: String = "Esta é uma mensagem de alerta!"
                    override val actionLabel: String = "OK"
                    override val withDismissAction: Boolean = false
                    override val duration: SnackbarDuration = SnackbarDuration.Short
                }
                override fun performAction() {}
                override fun dismiss() {}
            }
            SnackBarKiko(snackbarData = mockData)
        }
    }
}
