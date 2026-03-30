package com.kiko.kikocomponentes.ui.screens.caroussel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.appbase.LayoutBaseKiko
import com.kiko.kikocomponentes.components.caroussel.CarouselKiko
import com.kiko.kikocomponentes.ui.theme.AppThemeType
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun CarouselScreen(
    onBack: () -> Unit,
    isDarkTheme: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedTheme: AppThemeType,
    onThemeTypeChange: (AppThemeType) -> Unit
) {
    val carouselCode = """
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun CarouselKiko() {
            // ... lista de itens com imagens (R.drawable.fundo1, etc)
            
            HorizontalMultiBrowseCarousel(
                state = rememberCarouselState { items.count() },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                preferredItemWidth = 186.dp,
                itemSpacing = 8.dp,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) { i ->
                val item = items[i]
                Image(
                    modifier = Modifier
                        .height(205.dp)
                        .maskClip(MaterialTheme.shapes.extraLarge),
                    painter = painterResource(id = item.imageResId),
                    contentDescription = item.contentDescription,
                    contentScale = ContentScale.Crop
                )
            }
        }
    """.trimIndent()

    LayoutBaseKiko(
        title = "Carousel",
        onBack = onBack,
        componentCode = carouselCode,
        isDarkTheme = isDarkTheme,
        onDarkModeChange = onDarkModeChange,
        selectedTheme = selectedTheme,
        onThemeTypeChange = onThemeTypeChange
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Demonstração de Carousel",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            CarouselKiko()
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "O CarouselKiko permite navegar entre imagens de forma fluida utilizando o HorizontalMultiBrowseCarousel do Material 3.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Carousel Screen Light")
@Composable
fun CarouselScreenPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        CarouselScreen(
            onBack = {},
            isDarkTheme = false,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Carousel Screen Dark")
@Composable
fun CarouselScreenPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        CarouselScreen(
            onBack = {},
            isDarkTheme = true,
            onDarkModeChange = {},
            selectedTheme = AppThemeType.PADRAO,
            onThemeTypeChange = {}
        )
    }
}
