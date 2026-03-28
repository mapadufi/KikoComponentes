package com.kiko.kikocomponentes.components.loadingprogress

import android.content.res.Configuration
import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.WavyProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme

@Composable
fun ProgressLinearKiko(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.tertiary,
    trackColor: Color = MaterialTheme.colorScheme.secondaryContainer
) {
    LinearProgressIndicator(
        modifier = modifier,
        color = color,
        trackColor = trackColor
    )
}

@Composable
fun ProgressCircularKiko(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.tertiary,
    trackColor: Color = MaterialTheme.colorScheme.secondaryContainer
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color,
        trackColor = trackColor
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ProgressAngularKiko(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.tertiary,
    trackColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    stroke: Stroke = WavyProgressIndicatorDefaults.linearIndicatorStroke,
    trackStroke: Stroke = WavyProgressIndicatorDefaults.linearTrackStroke,
    gapSize: Dp = WavyProgressIndicatorDefaults.LinearIndicatorTrackGapSize,
    @FloatRange(from = 0.0, to = 1.0) amplitude: Float = 1.0f,
    wavelength: Dp = WavyProgressIndicatorDefaults.LinearIndeterminateWavelength,
    waveSpeed: Dp = wavelength
) {
    LinearWavyProgressIndicator(
        modifier = modifier,
        color = color,
        trackColor = trackColor,
        stroke = stroke,
        trackStroke = trackStroke,
        gapSize = gapSize,
        amplitude = amplitude,
        wavelength = wavelength,
        waveSpeed = waveSpeed
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CircularProgressAngularKiko(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.tertiary,
    trackColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    stroke: Stroke = WavyProgressIndicatorDefaults.circularIndicatorStroke,
    trackStroke: Stroke = WavyProgressIndicatorDefaults.circularTrackStroke,
    gapSize: Dp = WavyProgressIndicatorDefaults.CircularIndicatorTrackGapSize,
    @FloatRange(from = 0.0, to = 1.0) amplitude: Float = 1.0f,
    wavelength: Dp = WavyProgressIndicatorDefaults.LinearIndeterminateWavelength,
) {
    CircularWavyProgressIndicator(
        modifier = modifier,
        color = color,
        trackColor = trackColor,
        stroke = stroke,
        trackStroke = trackStroke,
        gapSize = gapSize,
        amplitude = amplitude,
        wavelength = wavelength
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview(
    name = "All Indicators - Light",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun ProgressKikoPreviewLight() {
    KikoComponentesTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            ProgressLinearKiko(modifier = Modifier.fillMaxWidth())
            ProgressCircularKiko(modifier = Modifier.size(48.dp))
            ProgressAngularKiko(modifier = Modifier.fillMaxWidth())
            CircularProgressAngularKiko(modifier = Modifier.size(48.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview(
    name = "All Indicators - Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ProgressKikoPreviewDark() {
    KikoComponentesTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            ProgressLinearKiko(modifier = Modifier.fillMaxWidth())
            ProgressCircularKiko(modifier = Modifier.size(48.dp))
            ProgressAngularKiko(modifier = Modifier.fillMaxWidth())
            CircularProgressAngularKiko(modifier = Modifier.size(48.dp))
        }
    }
}
