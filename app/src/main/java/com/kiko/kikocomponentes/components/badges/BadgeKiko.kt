package com.kiko.kikocomponentes.components.badges

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.components.buttons.KikoExtraButton

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
                        Text("$itemCount", color = MaterialTheme.colorScheme.onError)
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
