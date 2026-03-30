package com.kiko.kikocomponentes.ui.screens.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.cards.CardMinimalKiko
import com.kiko.kikocomponentes.components.cards.FilledCardKiko
import com.kiko.kikocomponentes.components.cards.OutlinedCardKiko
import com.kiko.kikocomponentes.components.cards.PersonCardKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun CardsScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val cardsCode = """
        CardMinimalKiko()
        
        FilledCardKiko()
        
        OutlinedCardKiko()
        
        PersonCardKiko(
            avatarLetter = "K",
            title = "Kiko",
            subtitle = "Desenvolvedor Android",
            description = "Especialista em Jetpack Compose."
        )
    """.trimIndent()

    LayoutBaseKiko(
        title = "Cards",
        onBack = onBack,
        componentCode = cardsCode,
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
                text = "Exemplos de Cards",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text("Minimal Card", color = MaterialTheme.colorScheme.tertiary)
            CardMinimalKiko()

            Text("Filled Card", color = MaterialTheme.colorScheme.tertiary)
            FilledCardKiko()

            Text("Outlined Card", color = MaterialTheme.colorScheme.tertiary)
            OutlinedCardKiko()

            Text("Person Card", color = MaterialTheme.colorScheme.tertiary)
            PersonCardKiko(
                avatarLetter = "K",
                title = "Kiko",
                subtitle = "Desenvolvedor Android",
                description = "Especialista em Jetpack Compose e Material 3."
            )
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Cards Screen Light")
@Composable
fun CardsScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        CardsScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Cards Screen Dark")
@Composable
fun CardsScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        CardsScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
