package com.example.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.RoundBackground
import com.example.designsystem.theme.Gray02
import com.example.designsystem.theme.Gray05
import com.example.designsystem.theme.MapNoteTheme
import com.example.designsystem.theme.MapNoteTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapMainTextField(text: String, onValueChange: (String) -> Unit, textStyle: TextStyle) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Gray02,
            containerColor = Gray05,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            ),
        textStyle = textStyle

    )
}

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun a() {
    var textLayoutResult by remember {
        mutableStateOf<TextLayoutResult?>(null)
    }
    Surface(modifier = Modifier.size(600.dp)) {
        Box(contentAlignment = Alignment.TopCenter) {
            BasicTextField(
                value = "NHN FORWARD 2022 발표 \n 아자아자 화이팅!",
                onValueChange = {},
                onTextLayout = {
                    textLayoutResult = it
                },
                decorationBox = { innerTextField ->
                    RoundBackground(textLayoutResult, 5.dp, 5.dp)
                    innerTextField()
                },
                textStyle = TextStyle().copy(color = Color.White , textAlign = TextAlign.Center ),
                interactionSource =  remember { MutableInteractionSource() }
            )
        }
    }

}

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun test() {
    var value by remember { mutableStateOf(TextFieldValue("")) }
    BasicTextField(
        value = value,
        onValueChange = { value = it },
        decorationBox = { innerTextField ->
            Row(
                Modifier
                    .background(Color.LightGray, RoundedCornerShape(percent = 30))
                    .padding(16.dp)
            ) {

                if (value.text.isEmpty()) {
                    Text("Label")
                }
                innerTextField()  //<-- Add this
            }
        },
    )
}

@Preview(name = "Light Mode", showBackground = true)
@Composable
fun mapMainTextFieldPreview() {
    MapNoteTheme {
        MapMainTextField("하하", {}, textStyle = MapNoteTypography.labelSmall)
    }
}
