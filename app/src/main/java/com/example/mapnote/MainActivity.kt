package com.example.mapnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.component.MapMainTextField
import com.example.designsystem.component.MapNoteButton
import com.example.designsystem.theme.MapNoteTheme
import com.naver.maps.map.compose.ExperimentalNaverMapApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalNaverMapApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 20.dp)) {
        Spacer(modifier = Modifier.height(60.dp))
        Image(imageVector = ImageVector.vectorResource(id = R.drawable.mapnote), contentDescription = "Mapnote")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "맵 노트에 오신것을 환영합니다.", Modifier.padding(bottom = 8.dp))
        Text(text = "서비스 이용을 위해 로그인이 필요합니다.", Modifier.padding(bottom = 8.dp))
        Spacer(modifier = Modifier.height(30.dp))
        MapMainTextField(text = "이메일", onValueChange = {}, textStyle = MaterialTheme.typography.labelSmall)
        Spacer(modifier = Modifier.height(6.dp))
        MapMainTextField(text = "비밀번호", onValueChange = {}, textStyle = MaterialTheme.typography.labelSmall)
        Spacer(modifier = Modifier.height(30.dp))
        Row() {

        }
        Spacer(modifier = Modifier.height(60.dp))
        MapNoteButton(modifier = Modifier.height(56.dp), onClick = { /*TODO*/ }) {
            Text(text = "로그인")
        }
        Spacer(modifier = Modifier.height(60.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(
                modifier = Modifier
                    .width(100.dp)
                    .height(0.5.dp)
                    .background(color = MaterialTheme.colorScheme.onBackground)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(text = "간편 로그인")
            Spacer(modifier = Modifier.width(25.dp))
            Spacer(
                modifier = Modifier
                    .width(100.dp)
                    .height(0.5.dp)
                    .background(color = MaterialTheme.colorScheme.onBackground)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MapNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Greeting("Android")
        }
    }
}
