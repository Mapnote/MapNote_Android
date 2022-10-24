package com.example.designsystem.component

import android.graphics.drawable.Animatable
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.component.MapNoteLoadingDefaults.OneTime
import com.example.designsystem.component.MapNoteLoadingDefaults.ThreeTIme
import com.example.designsystem.component.MapNoteLoadingDefaults.TotalTime
import com.example.designsystem.component.MapNoteLoadingDefaults.TransParentTime
import com.example.designsystem.component.MapNoteLoadingDefaults.TwoTime
import com.example.designsystem.theme.Loading1
import com.example.designsystem.theme.Loading2
import com.example.designsystem.theme.Loading3
import com.example.designsystem.theme.MapNoteTheme
import com.example.designsystem.theme.Primary
import kotlinx.coroutines.delay

//@Composable
//fun MapNoteLoading() {
//    val infiniteTransition = rememberInfiniteTransition()
//
//    val colorAnimValues = (0 until NUM_OF_LINES).map { index ->
//        infiniteTransition.animateColor(
//            initialValue = baseLineColor,
//            targetValue = baseLineColor,
//            animationSpec = infiniteRepeatable(
//                animation = keyframes {
//                    durationMillis = ROTATION_TIME / 2
//                    progressLineColor at ROTATION_TIME / NUM_OF_LINES / 2 with LinearEasing
//                    baseLineColor at ROTATION_TIME / NUM_OF_LINES with LinearEasing
//                },
//                repeatMode = RepeatMode.Restart,
//                initialStartOffset = StartOffset(ROTATION_TIME / NUM_OF_LINES / 2 * index)
//            )
//        )
//    }
//
//
//    Canvas(
//        modifier = Modifier
//            .width(30.dp)
//            .height(6.dp)
//    ) {
//        drawCircle(
//            color = Color.Green,
//            radius = 3.dp.toPx(),
//            center = Offset(
//                x = 3.dp.toPx(),
//                y = WheelSize.toPx()
//            )
//        )
//
//        drawCircle(
//            color = Color.Green,
//            radius = 3.dp.toPx(),
//            center = Offset(
//                x = 15.dp.toPx(),
//                y = WheelSize.toPx()
//            )
//        )
//
//        drawCircle(
//            color = Color.Green,
//            radius = 3.dp.toPx(),
//            center = Offset(
//                x = 27.dp.toPx(),
//                y = WheelSize.toPx()
//            )
//        )
//    }
//}

@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 25.dp,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp,

    ) {

    //새로운 애니메이션이 들어오면 취소를 해주는 Animatable
    val circles = listOf(
        remember { androidx.compose.animation.core.Animatable(initialValue = 0f) },
        remember { androidx.compose.animation.core.Animatable(initialValue = 0f) },
        remember { androidx.compose.animation.core.Animatable(initialValue = 0f) }
    )

    val colors = listOf(
        remember { Animatable(Color.Transparent) },
        remember { Animatable(Color.Transparent) },
        remember { Animatable(Color.Transparent) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable) {
            delay(index * 200L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = TotalTime
                        0.0f at TransParentTime with LinearOutSlowInEasing
                        1.0f at OneTime + TransParentTime with LinearOutSlowInEasing
                        0.0f at OneTime + TwoTime + TransParentTime with LinearOutSlowInEasing
                        0.0f at OneTime + TwoTime + ThreeTIme + TransParentTime with LinearEasing
                    },
                    repeatMode = RepeatMode.Restart
                ),
            )
        }
    }

    colors.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable) {
            delay(index * 200L)
            animatable.animateTo(
                targetValue = Loading3,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = TotalTime
                        Color.Transparent at TransParentTime
                        Loading1 at 400
                        Loading2 at OneTime + TwoTime + TransParentTime
                        Color.Transparent at OneTime + TwoTime + ThreeTIme + TransParentTime
                    },
                    repeatMode = RepeatMode.Restart
                ),
            )

        }
    }

    val circleValues = circles.map { it.value }
    val colorsValues = colors.map { it.value }
    val distance = with(LocalDensity.current) { travelDistance.toPx() }

    val lastCircle = circleValues.size - 1

    Row(modifier = modifier) {
        circleValues.forEachIndexed { index, value ->
            Box(
                modifier = Modifier
                    .size(circleSize)
                    .graphicsLayer {
                        translationY = -value * distance
                    }
                    .background(
                        color = colorsValues[index],
                        shape = CircleShape
                    )
            )
            if (index != lastCircle) Spacer(modifier = Modifier.width(spaceBetween))
        }
    }
}

@Preview
@Composable
fun MapNoteLoadingPreview() {
    MapNoteTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                LoadingAnimation()

            }
        }
    }
}

object MapNoteLoadingDefaults {
    val TransParentTime = 300
    val OneTime = 600
    val TwoTime = 600
    val ThreeTIme = 300

    val TotalTime = TransParentTime + OneTime + TwoTime + ThreeTIme

}
