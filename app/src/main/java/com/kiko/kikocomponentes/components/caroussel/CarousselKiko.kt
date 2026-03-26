package com.kiko.kikocomponentes.components.caroussel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.R
import com.kiko.kofre.ui.theme.KikoComponentesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselKiko() {
    data class CarouselItem(
        val id: Int,
        @DrawableRes val imageResId: Int,
        val contentDescription: String
    )

    val items = remember {
        listOf(
            CarouselItem(0, R.drawable.fundo1, "gotas"),
            CarouselItem(1, R.drawable.fundo2, "pedras"),
            CarouselItem(2, R.drawable.fundo3, "pedra"),
            CarouselItem(3, R.drawable.fundo4, "zen"),
        )
    }

    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { items.count() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 16.dp, bottom = 16.dp),
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

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Carousel Light")
@Composable
fun CarouselKikoPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center // Centraliza verticalmente
        ) {
            CarouselKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "Carousel Dark")
@Composable
fun CarouselKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center // Centraliza verticalmente
        ) {
            CarouselKiko()
        }
    }
}
