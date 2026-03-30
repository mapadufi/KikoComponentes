package com.kiko.kikocomponentes.ui.screens.outlined

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.outlined.KikoOutlinedTextField
import com.kiko.kikocomponentes.components.outlined.KikoOutlinedTextFieldErro
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun OutlinedScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val outlinedCode = """
        // Campo padrão
        KikoOutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = "Nome de Usuário",
            leadingIcon = Icons.Default.Person
        )

        // Campo de erro
        KikoOutlinedTextFieldErro(
            label = "E-mail",
            value = email,
            onValueChange = { email = it },
            leadingIcon = Icons.Default.Email,
            supportingText = "Formato de e-mail inválido"
        )
    """.trimIndent()

    LayoutBaseKiko(
        title = "Outlined Fields",
        onBack = onBack,
        componentCode = outlinedCode,
        isDarkTheme = isDarkTheme,
        onDarkModeChange = onDarkModeChange,
        selectedTheme = selectedTheme,
        onThemeTypeChange = onThemeTypeChange
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "Campos de Texto Personalizados",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            KikoOutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = "Nome de Usuário",
                leadingIcon = Icons.Default.Person
            )

            KikoOutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = "Senha",
                leadingIcon = Icons.Default.Lock
            )

            KikoOutlinedTextFieldErro(
                label = "E-mail",
                value = email,
                onValueChange = { email = it },
                leadingIcon = Icons.Default.Email,
                supportingText = "Formato de e-mail inválido"
            )
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Outlined Screen Light")
@Composable
fun OutlinedScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        OutlinedScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Outlined Screen Dark")
@Composable
fun OutlinedScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        OutlinedScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
