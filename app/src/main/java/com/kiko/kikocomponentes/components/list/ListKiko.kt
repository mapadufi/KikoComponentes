package com.kiko.kikocomponentes.components.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.R
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme


data class KikoListItemData(
    val id: Int,
    val title: String,
    val imageRes: Int
)

@Composable
fun ListKiko(
    items: List<KikoListItemData>,
    modifier: Modifier = Modifier,
    onItemClick: (KikoListItemData) -> Unit = {},
    onMoreClick: (KikoListItemData) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 32.dp, bottom = 16.dp) // Aumentado o padding no topo
    ) {
        items(items) { item ->
            KikoListItem(
                item = item,
                onClick = { onItemClick(item) },
                onMoreClick = { onMoreClick(item) }
            )
        }
    }
}

@Composable
fun KikoListItem(
    item: KikoListItemData,
    onClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    ListItem(
        modifier = Modifier.fillMaxWidth(),
        headlineContent = {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
        },
        leadingContent = {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        },
        trailingContent = {
            IconButton(onClick = onMoreClick) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "Mais opções",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        },
        colors = ListItemDefaults.colors(
            containerColor = androidx.compose.ui.graphics.Color.Transparent
        )
    )
}

// Itens de exemplo para o Preview
private val previewItems = listOf(
    KikoListItemData(1, "Exemplo 1", R.drawable.fundo1),
    KikoListItemData(2, "Exemplo 2", R.drawable.fundo2),
    KikoListItemData(3, "Exemplo 3", R.drawable.fundo3),
    KikoListItemData(4, "Exemplo 4", R.drawable.fundo4),
    KikoListItemData(5, "Exemplo 5", R.drawable.fundo1)
)

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "List Light")
@Composable
fun ListKikoPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            ListKiko(items = previewItems)
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "List Dark")
@Composable
fun ListKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            ListKiko(items = previewItems)
        }
    }
}
