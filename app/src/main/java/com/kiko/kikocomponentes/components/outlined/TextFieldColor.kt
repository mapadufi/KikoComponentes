package com.kiko.kikocomponentes.components.outlined

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun kikoTextFieldColors(
    isError: Boolean = false,
    mainColor: Color = MaterialTheme.colorScheme.tertiary
): TextFieldColors {
    val colors = MaterialTheme.colorScheme
    val selectionColors = TextSelectionColors(
        handleColor = mainColor,
        backgroundColor = mainColor.copy(alpha = 0.4f)
    )

    return TextFieldDefaults.colors(
        focusedTextColor = mainColor,
        unfocusedTextColor = mainColor,
        disabledTextColor = colors.onSurface.copy(alpha = 0.38f),
        errorTextColor = colors.error,
        focusedContainerColor = colors.onPrimary,
        unfocusedContainerColor = colors.surface,
        disabledContainerColor = colors.surface,
        errorContainerColor = colors.onError,
        cursorColor = mainColor,
        errorCursorColor = colors.error,
        selectionColors = selectionColors,
        focusedIndicatorColor = if (isError) colors.error else mainColor,
        unfocusedIndicatorColor = if (isError) colors.error else mainColor,
        disabledIndicatorColor = mainColor.copy(alpha = 0.38f),
        errorIndicatorColor = colors.error,
        focusedLeadingIconColor = if (isError) colors.error else mainColor,
        unfocusedLeadingIconColor = if (isError) colors.error else mainColor,
        disabledLeadingIconColor = mainColor.copy(alpha = 0.38f),
        errorLeadingIconColor = colors.error,
        focusedLabelColor = if (isError) colors.error else mainColor,
        unfocusedLabelColor = mainColor,
        disabledLabelColor = mainColor.copy(alpha = 0.38f),
        errorLabelColor = colors.error,
        focusedSupportingTextColor = if (isError) colors.error else mainColor,
        unfocusedSupportingTextColor = mainColor,
        disabledSupportingTextColor = mainColor.copy(alpha = 0.38f),
        errorSupportingTextColor = colors.error,
        focusedTrailingIconColor = mainColor,
        unfocusedTrailingIconColor = mainColor,
        disabledTrailingIconColor = mainColor.copy(alpha = 0.38f),
        errorTrailingIconColor = colors.error
    )
}
