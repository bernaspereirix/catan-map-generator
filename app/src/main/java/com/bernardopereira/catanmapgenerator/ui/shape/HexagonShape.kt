package com.bernardopereira.catanmapgenerator.ui.shape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.min
import kotlin.math.sqrt

class HexagonShape(private val isBackground: Boolean) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawCustomHexagonPath(size, isBackground)
        )
    }
}

fun drawCustomHexagonPath(size: Size, isBackground: Boolean): Path {
    return Path().apply {
        val radius = min(size.width / 1.8f, size.height / 2f)
        if (isBackground) {
            customBackgroundHexagon(radius, size)
        } else {
            customHexagon(radius, size)
        }
    }
}

fun Path.customHexagon(radius: Float, size: Size) {
    val triangleHeight = (sqrt(3.0) * radius / 2)
    val centerX = size.width / 2
    val centerY = size.height / 2

    moveTo(centerX, centerY + radius)
    lineTo((centerX - triangleHeight - 13).toFloat(), centerY + radius / 2)
    lineTo((centerX - triangleHeight - 13).toFloat(), centerY - radius / 2)
    lineTo(centerX, centerY - radius)
    lineTo((centerX + triangleHeight + 13).toFloat(), centerY - radius / 2)
    lineTo((centerX + triangleHeight + 13).toFloat(), centerY + radius / 2)

    close()
}

fun Path.customBackgroundHexagon(radius: Float, size: Size) {
    val triangleHeight = (sqrt(3.0) * radius / 2)
    val centerX = size.width / 2
    val centerY = size.height / 2

    moveTo((centerX - (triangleHeight / 2)).toFloat(), centerY + radius)
    lineTo((centerX + (triangleHeight / 2)).toFloat(), centerY + radius)
    lineTo((centerX + triangleHeight).toFloat(), (centerY + radius / 2.3).toFloat())
    lineTo((centerX + triangleHeight).toFloat(), (centerY - radius / 2.3).toFloat())
    lineTo((centerX + triangleHeight / 2).toFloat(), centerY - radius)
    lineTo((centerX - triangleHeight / 2).toFloat(), centerY - radius)
    lineTo((centerX - triangleHeight).toFloat(), (centerY - radius / 2.3).toFloat())
    lineTo((centerX - triangleHeight).toFloat(), (centerY + radius / 2.3).toFloat())

    close()
}