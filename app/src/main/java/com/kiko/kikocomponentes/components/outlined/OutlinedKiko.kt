package com.kiko.kikocomponentes.components.outlined

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KikoOutlinedTextField(
    label: String = "Digite algo",
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    isError: Boolean = false,
    supportingText: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    mainColor: Color = MaterialTheme.colorScheme.tertiary
) {
    val colors = MaterialTheme.colorScheme

    val selectionColors = TextSelectionColors(
        handleColor = mainColor,
        backgroundColor = mainColor.copy(alpha = 0.4f)
    )

    CompositionLocalProvider(LocalTextSelectionColors provides selectionColors) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = modifier.fillMaxWidth(),
            singleLine = singleLine,
            maxLines = maxLines,
            isError = isError,
            shape = RoundedCornerShape(16.dp),
            enabled = enabled,
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = "$label Icon",
                        tint = if (isError) colors.error else mainColor
                    )
                }
            },
            supportingText = supportingText?.let {
                {
                    Text(
                        text = it,
                        color = if (isError) colors.error else mainColor
                    )
                }
            },
            colors = kikoTextFieldColors(isError = isError, mainColor = mainColor),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions
        )
    }
}

@Composable
fun KikoOutlinedTextFieldErro(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    supportingText: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    mainColor: Color = MaterialTheme.colorScheme.error
) {
    KikoOutlinedTextField(
        label = label,
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        leadingIcon = leadingIcon,
        isError = true,
        supportingText = supportingText,
        keyboardOptions = keyboardOptions,
        mainColor = mainColor
    )
}

@Composable
private fun OutlinedTextFieldScreenKiko() {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        KikoOutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = "Nome de Usuário",
            leadingIcon = Icons.Default.Person
        )

        KikoOutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = "Senha",
            leadingIcon = Icons.Default.Lock,
            visualTransformation = VisualTransformation.None
        )

        KikoOutlinedTextFieldErro(
            label = "E-mail",
            value = text,
            onValueChange = { text = it },
            leadingIcon = Icons.Default.Email,
            supportingText = "Formato de e-mail inválido"
        )
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "OutlinedTextField Light")
@Composable
fun KikoOutlinedTextFieldPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextFieldScreenKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "OutlinedTextField Dark")
@Composable
fun KikoOutlinedTextFieldPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextFieldScreenKiko()
        }
    }
}
