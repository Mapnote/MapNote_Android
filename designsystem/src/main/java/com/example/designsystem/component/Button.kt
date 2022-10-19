package com.example.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.MapNoteTheme
import com.example.designsystem.theme.Primary

@Composable
fun MapNoteButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = Primary, contentColor = Color.White),
    contentPaddingValues: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        shape = RectangleShape,
        contentPadding = contentPaddingValues,
    ) {
        content()
    }
}

@Composable
fun MapNoteRoundButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Primary),
    contentPaddingValues: PaddingValues = PaddingValues(horizontal =14.dp, vertical =8.dp),
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        border = BorderStroke(width = 0.7.dp, color = Primary),
        contentPadding = contentPaddingValues,
    ) {
        content()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun MapNoteTextButtonPreview() {
    MapNoteTheme {
        MapNoteButton(
            onClick = {},
            enabled = true
        ) {
            Text(text = "위치설정완료")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun MapNoteRoundButtonPreview() {
    MapNoteTheme {
        MapNoteRoundButton(
            onClick = {},
            enabled = true,
        ) {
            Text(text = "위치설정완료")
        }
    }
}



