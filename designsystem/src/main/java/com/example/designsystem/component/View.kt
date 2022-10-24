package com.example.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.theme.Gray04
import com.example.designsystem.theme.MapNoteTheme

@Composable
fun MapNoteTodoView(
    modifier: Modifier = Modifier,
    @DrawableRes stickerDrawableRes: Int,
    labelText: String,
    contentText: String,
    checkButton: Boolean = true,
    background: Color = Color.White,
    shadowElevation: Dp = 0.dp
) {
    Surface(
        modifier = Modifier
            .width(320.dp)
            .height(78.dp)
            .then(modifier)
            .clip(RoundedCornerShape(10.dp)),
        tonalElevation = shadowElevation
    ) {
        Surface(color = background) {
            Box() {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterStart)
                        .padding(start = 12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(painter = painterResource(id = stickerDrawableRes), contentDescription = "스티커 사진")
                    Spacer(modifier = Modifier.width(14.dp))
                    Column() {
                        Text(
                            modifier= Modifier.padding(end = 50.dp),
                            text = labelText, style = MaterialTheme.typography.labelMedium, maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Spacer(modifier = Modifier.height(1.dp))
                        Text(
                            modifier= Modifier.padding(end = 50.dp),
                            text = contentText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                Image(
                    painter = painterResource(id = if (checkButton) R.drawable.btn_check_on else R.drawable.btn_check_off),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 20.dp),
                    contentDescription = "스티커 사진"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun MapNoteTodoButtonPreview() {
    MapNoteTheme {
        MapNoteTodoView(
            modifier = Modifier.border(border = BorderStroke(1.dp, Gray04), shape = RoundedCornerShape(10.dp)),
            stickerDrawableRes = R.drawable.sticker01,
            labelText = "CU 경희대점",
            contentText = "포켓몬 빵 사기"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun ElavationMapNoteTodoViewPreview() {
    MapNoteTheme {
        MapNoteTodoView(
            stickerDrawableRes = R.drawable.sticker01,
            labelText = "CU 경희대점",
            contentText = "포켓몬 빵 사기",
            shadowElevation = 10.dp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun MuchElavationMapNoteTodoViewPreview() {
    MapNoteTheme {
        MapNoteTodoView(
            stickerDrawableRes = R.drawable.sticker01,
            labelText = "CU 경희대점 CU 경희대점 CU 경희대점 CU 경희대점 CU 경희대점",
            contentText = "포켓몬 빵 사기 포켓몬 빵 사기 포켓몬 빵 사기 포켓몬 빵 사기",
            shadowElevation = 10.dp
        )
    }
}