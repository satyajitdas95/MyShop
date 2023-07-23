package com.satyajit.myshop.ui.custom

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DrawHorizontalDashLine(color:Color) {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 10f), 0f)
    Canvas(
        Modifier.fillMaxWidth()
    ) {
        drawLine(
            color = color,
            strokeWidth = 5f,
            start = Offset(20f, 0f),
            end = Offset(size.width - 20, 0f),
            pathEffect = pathEffect
        )
    }
}

@Composable
fun DrawVerticalDashLine(color:Color) {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 10f), 0f)
    Canvas(
        Modifier.fillMaxHeight()
    ) {
        drawLine(
            color = color,
            strokeWidth = 5f,
            start = Offset(0f, 20f),
            end = Offset(0f, size.height - 20),
            pathEffect = pathEffect
        )
    }
}

@Preview
@Composable
fun PrevHorizontalDashLine() {
    DrawHorizontalDashLine(Color.Black)
}

@Preview
@Composable
fun PrevVerticalDashLine() {
    DrawVerticalDashLine(Color.Black)
}