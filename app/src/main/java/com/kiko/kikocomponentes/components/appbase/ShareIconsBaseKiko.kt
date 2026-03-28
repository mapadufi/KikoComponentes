package com.kiko.kikocomponentes.components.appbase

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme


@Composable
fun ShareIconsBaseKiko(
    componentCode: String = "",
    componentName: String = "Componente",
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Enviar por E-mail
        IconButton(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Código do componente: $componentName")
                putExtra(Intent.EXTRA_TEXT, componentCode)
            }
            context.startActivity(Intent.createChooser(intent, "Enviar E-mail"))
        }) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email",
                tint = MaterialTheme.colorScheme.tertiary
            )
        }

        // Enviar por SMS
        IconButton(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:")
                putExtra("sms_body", componentCode)
            }
            context.startActivity(intent)
        }) {
            Icon(
                imageVector = Icons.Default.Message,
                contentDescription = "SMS",
                tint = MaterialTheme.colorScheme.tertiary
            )
        }

        // Enviar por WhatsApp
        IconButton(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                `package` = "com.whatsapp"
                putExtra(Intent.EXTRA_TEXT, componentCode)
            }
            try {
                context.startActivity(intent)
            } catch (e: Exception) {
                // Caso não tenha WhatsApp, abre o compartilhamento padrão
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, componentCode)
                }
                context.startActivity(Intent.createChooser(shareIntent, "Compartilhar"))
            }
        }) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "WhatsApp",
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, name = "ShareIcons Light")
@Composable
fun ShareIconsBaseKikoPreviewLight() {
    KikoComponentesTheme (darkTheme = false) {
        ShareIconsBaseKiko(
            componentCode = "fun Exemplo() { }",
            componentName = "Exemplo"
        )
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, name = "ShareIcons Dark")
@Composable
fun ShareIconsBaseKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        ShareIconsBaseKiko(
            componentCode = "fun Exemplo() { }",
            componentName = "Exemplo"
        )
    }
}
