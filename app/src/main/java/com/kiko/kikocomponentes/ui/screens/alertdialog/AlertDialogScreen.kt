package com.kiko.kikocomponentes.ui.screens.alertdialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.alertdialog.KikoAlertDialog
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.buttons.KikoExtraButton
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun AlertDialogScreen(
    onBack: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    // Código real do componente para ser compartilhado
    val alertCode = """
        @Composable
        fun KikoAlertDialog(
            onDismissRequest: () -> Unit,
            title: String,
            text: String,
            confirmText: String = "Confirmar",
            dismissText: String = "Voltar",
            onConfirm: () -> Unit,
            onDismiss: () -> Unit = onDismissRequest
        ) {
            Dialog(onDismissRequest = onDismissRequest) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, RoundedCornerShape(12.dp))
                        .border(1.dp, MaterialTheme.colorScheme.tertiary, RoundedCornerShape(12.dp)),
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.tertiary,
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = title,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = text,
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary),
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End)
                        ) {
                            KikoExtraButton(
                                onClick = onConfirm,
                                text = confirmText,
                                modifier = Modifier.weight(1f)
                            )
                            KikoExtraButton(
                                onClick = onDismiss,
                                text = dismissText,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Alert Dialog",
        onBack = onBack,
        componentCode = alertCode
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Exemplo de AlertDialog",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            KikoExtraButton(
                text = "Abrir Alerta",
                onClick = { showDialog = true }
            )
        }

        if (showDialog) {
            KikoAlertDialog(
                onDismissRequest = { showDialog = false },
                title = "Atenção",
                text = "Este é o componente KikoAlertDialog sendo demonstrado na sua própria tela de componente.",
                onConfirm = {
                    showDialog = false
                },
                onDismiss = {
                    showDialog = false
                }
            )
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "AlertDialog Screen Light")
@Composable
fun AlertDialogScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        AlertDialogScreen(onBack = {})
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "AlertDialog Screen Dark")
@Composable
fun AlertDialogScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        AlertDialogScreen(onBack = {})
    }
}
