package com.kiko.kikocomponentes.ui.screens.badges

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.badges.BadgeInteractiveKiko
import com.kiko.kikocomponentes.components.badges.BadgeKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun BadgeScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val badgeCode = """
        @Composable
        fun BadgeKiko() {
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Mail,
                    contentDescription = "Email",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }

        @Composable
        fun BadgeInteractiveKiko() {
            var itemCount by remember { mutableStateOf(0) }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                BadgedBox(
                    badge = {
                        if (itemCount > 0) {
                            Badge(
                                containerColor = MaterialTheme.colorScheme.error,
                                contentColor = MaterialTheme.colorScheme.onError
                            ) {
                                Text("${"$"}itemCount", color = MaterialTheme.colorScheme.onError)
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Shopping cart",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
                KikoExtraButton(
                    text = "Add item",
                    onClick = { itemCount++ }
                )
            }
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Badges",
        onBack = onBack,
        componentCode = badgeCode,
        isDarkTheme = isDarkTheme,
        onDarkModeChange = onDarkModeChange,
        selectedTheme = selectedTheme,
        onThemeTypeChange = onThemeTypeChange
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
        ) {
            Text(
                text = "Exemplos de Badges",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text(
                text = "Badge Simples",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
            BadgeKiko()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Badge Interativo",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
            BadgeInteractiveKiko()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Badge Screen Light")
@Composable
fun BadgeScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        BadgeScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Badge Screen Dark")
@Composable
fun BadgeScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        BadgeScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
