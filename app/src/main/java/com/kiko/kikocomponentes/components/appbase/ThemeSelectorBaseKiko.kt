package com.kiko.kikocomponentes.components.appbase

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness2
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme
import com.kiko.kofre.ui.theme.*

@Composable
fun KikoSwitchWithIconInsideThumb(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    thumbColorChecked: Color = MaterialTheme.colorScheme.surface,
    thumbColorUnchecked: Color = MaterialTheme.colorScheme.primary,
    trackColorChecked: Color = MaterialTheme.colorScheme.onPrimary,
    trackColorUnchecked: Color = MaterialTheme.colorScheme.onPrimary
) {
    Switch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = thumbColorChecked,
            checkedTrackColor = trackColorChecked,
            uncheckedThumbColor = thumbColorUnchecked,
            uncheckedTrackColor = trackColorUnchecked,
            uncheckedBorderColor = MaterialTheme.colorScheme.primary,
            checkedBorderColor = MaterialTheme.colorScheme.tertiary
        ),
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Brightness2,
                    contentDescription = "Lua",
                    tint = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            }
        } else {
            {
                Icon(
                    imageVector = Icons.Filled.WbSunny,
                    contentDescription = "Sol",
                    tint = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            }
        }
    )
}

@Composable
fun ThemeSelectorBaseKiko(
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "Personalização",
            style = MaterialTheme.typography.titleMedium,
            color = colorScheme.tertiary
        )
        Text(
            "Selecione a cor e o modo de exibição",
            style = MaterialTheme.typography.bodySmall,
            color = colorScheme.tertiary.copy(alpha = 0.7f)
        )
        
        Spacer(Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Seletor de Cores
            val themes = listOf(
                AppThemeType.PADRAO to Primary900,
                AppThemeType.VERDE to Success900,
                AppThemeType.VERMELHO to Error900,
                AppThemeType.ROXO to Roxo900
            )

            themes.forEach { (theme, color) ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(color, shape = MaterialTheme.shapes.medium)
                        .clickable { onThemeTypeChange(theme) },
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedTheme == theme) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selecionado",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Espaçador para empurrar o switch se necessário ou apenas mantê-lo ao lado
            Spacer(modifier = Modifier.width(8.dp))

            // Switch ao lado da última cor
            KikoSwitchWithIconInsideThumb(
                checked = isDarkTheme,
                onCheckedChange = onDarkModeChange
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeSelectorBaseKikoPreview() {
    KikoComponentesTheme {
        var dark by remember { mutableStateOf(false) }
        var theme by remember { mutableStateOf(AppThemeType.PADRAO) }
        ThemeSelectorBaseKiko(
            isDarkTheme = dark,
            onDarkModeChange = { dark = it },
            selectedTheme = theme,
            onThemeTypeChange = { theme = it }
        )
    }
}
