package com.example.designsystem

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundBackground(
    textLayoutResult: TextLayoutResult?,
    paddingHorizontal: Dp,
    paddingVertical: Dp
) {
    val density = LocalDensity.current
    textLayoutResult?.let { textLayoutResult ->
        Canvas(modifier = Modifier) {
            val paint = Paint().apply {
                color = Color.Black

                pathEffect = PathEffect.cornerPathEffect(radius = 5.dp.toPx())
            }
            drawIntoCanvas {
                it.drawPath(createBackGroundPath(textLayoutResult, density, paddingHorizontal, paddingVertical), paint)
            }

        }
    }
}

fun createBackGroundPath(
    textLayoutResult: TextLayoutResult,
    density: Density,
    paddingHorizontal: Dp,
    paddingVertical: Dp
): Path {
    val backgroundShape = Path()

    repeat(textLayoutResult.lineCount) { lineIndex ->
        if (checkLineNotEmpty(textLayoutResult, lineIndex)) {
            createBackgroundRect(
                textLayoutResult,
                lineIndex,
                density,
                paddingHorizontal,
                paddingVertical
            ).also { rect ->
                backgroundShape.addRect(rect)
            }
        }
    }
    return backgroundShape
}

/**
 * textLayoutResult의 좌표에 따라 사각형을 만드는 함수
 *
 * @param textLayoutResult
 * @param lineIndex
 * @param density
 * @return
 */
fun createBackgroundRect(
    textLayoutResult: TextLayoutResult,
    lineIndex: Int,
    density: Density,
    paddingHorizontal: Dp,
    paddingVertical: Dp
): Rect {
    density

    return Rect(
        textLayoutResult.getLineLeft(lineIndex),
        textLayoutResult.getLineTop(lineIndex),
        textLayoutResult.getLineRight(lineIndex),
        textLayoutResult.getLineBottom(lineIndex)
    )
}

/**
 * 시작점과 끝점을 보고, 같으면 백그라운드를 그리지 않는다.
 *
 * @param textLayoutResult
 * @param lineIndex
 * @return
 */
fun checkLineNotEmpty(textLayoutResult: TextLayoutResult, lineIndex: Int): Boolean {
    val lineStart = textLayoutResult.getLineStart(lineIndex)
    val lineEnd = textLayoutResult.getLineEnd(lineIndex)

    //라인이 같을경우
    if (lineStart == lineEnd) return false
    //라인의 마지막이 \n일 경우
    if (textLayoutResult.layoutInput.text[lineStart] == '\n' && lineEnd - lineStart == 1) return false

    return true
}
