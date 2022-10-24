package com.example.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Preview(name = "Light Mode", showBackground = true)
@Composable
fun mapMainTextFieldPreview() {
    MapNoteTheme {
        MapMainTextField("하하", {}, textStyle = MapNoteTypography.labelSmall)
    }
}
