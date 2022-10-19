package com.example.mapnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mapnote.ui.theme.MapNoteTheme
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.MapProperties
import com.naver.maps.map.compose.MapUiSettings
import com.naver.maps.map.compose.NaverMap

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
                    var mapProperties by remember {
                        mutableStateOf(
                            MapProperties(maxZoom = 10.0, minZoom = 5.0)
                        )
                    }
                    var mapUiSettings by remember {
                        mutableStateOf(
                            MapUiSettings(isLocationButtonEnabled = false)
                        )
                    }
                    Box(Modifier.fillMaxSize()) {
                        NaverMap(properties = mapProperties, uiSettings = mapUiSettings)
                        Column {
                            Button(onClick = {
                                mapProperties = mapProperties.copy(
                                    isBuildingLayerGroupEnabled = !mapProperties.isBuildingLayerGroupEnabled
                                )
                            }) {
                                Text(text = "Toggle isBuildingLayerGroupEnabled")
                            }
                            Button(onClick = {
                                mapUiSettings = mapUiSettings.copy(
                                    isLocationButtonEnabled = !mapUiSettings.isLocationButtonEnabled
                                )
                            }) {
                                Text(text = "Toggle isLocationButtonEnabled")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MapNoteTheme {
        Greeting("Android")
    }
}
