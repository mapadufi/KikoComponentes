package com.kiko.kikocomponentes.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiko.kikocomponentes.R
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SplashScreen(onNavigateNext: () -> Unit) {
    val gradientColors = listOf(
        MaterialTheme.colorScheme.outline,
        MaterialTheme.colorScheme.outline
    )
    val appName = "Kiko Components"
    val iconSize = 160.dp
    val progressSize = 64.dp

    LaunchedEffect(Unit) {
        delay(2000) // Ajustado para 2 segundos conforme solicitado
        onNavigateNext()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = gradientColors)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = appName,
                color = MaterialTheme.colorScheme.onTertiary,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))
            
            Image(
                painter = painterResource(id = R.drawable.kiko),
                contentDescription = "Kiko Icon",
                modifier = Modifier.size(iconSize)
            )
            
            Spacer(modifier = Modifier.height(48.dp))
            
            CircularWavyProgressIndicator(
                modifier = Modifier.size(progressSize),
                color = MaterialTheme.colorScheme.onTertiary,
                trackColor = MaterialTheme.colorScheme.onTertiary.copy(alpha = 0.3f)
            )
        }
    }
}

// Previews
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenLightPreview() {
    KikoComponentesTheme(darkTheme = false) {
        SplashScreen(onNavigateNext = {})
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenDarkPreview() {
    KikoComponentesTheme(darkTheme = true) {
        SplashScreen(onNavigateNext = {})
    }
}
