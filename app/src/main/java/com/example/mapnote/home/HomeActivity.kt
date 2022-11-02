package com.example.mapnote.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.component.MainScreen
import com.example.designsystem.component.MapBottomSeatScaffold
import com.example.designsystem.component.MapNoteNavigationBar
import com.example.designsystem.component.MapNoteNavigationBarItem
import com.example.designsystem.theme.MapNoteTheme
import com.example.mapnote.R
import com.example.mapnote.model.previewTodoList
import com.example.mapnote.todo.TodoScreen
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.MapProperties
import com.naver.maps.map.compose.MapUiSettings
import com.naver.maps.map.compose.NaverMap

class HomeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MapNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeScaffold("Android") {scaffoldPaddingValue->
                        val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
                        val scope = rememberCoroutineScope()
                        MapBottomSeatScaffold(
                            scope,
                            bottomSheetScaffoldState,
                            scaffoldPaddingValue,
                            sheetContent = { TodoScreen(previewTodoList) }) {
                            NaverMapScreen(bottomPadding = it)
                        }

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun NaverMapScreen(
    bottomPadding: PaddingValues
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
    Box(
        Modifier
            .fillMaxSize()
            .padding(bottomPadding)
    ) {
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScaffold(name: String, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(bottomBar = {
        MapNoteNavigationBar() {
            items.forEach { screen ->
                MapNoteNavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.drawableRes),
                            contentDescription = stringResource(id = screen.stringRes)
                        )
                    },
                )
            }
        }
    }
    ) {
        content(it)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MapNoteTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            HomeScaffold("Android") {
                val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
                val scope = rememberCoroutineScope()
                MapBottomSeatScaffold(
                    scope,
                    bottomSheetScaffoldState,
                    it,
                    sheetContent = { TodoScreen(previewTodoList) }) {
                    NaverMapScreen(it)
                }
            }
        }
    }

}

val items = listOf(
    Screen.Write,
    Screen.Map,
    Screen.Info
)

sealed class Screen(val route: String, @StringRes val stringRes: Int, @DrawableRes val drawableRes: Int) {
    object Write : Screen("profile", R.string.text_calendar, com.example.designsystem.R.drawable.calander)
    object Map : Screen("profile", R.string.text_map, com.example.designsystem.R.drawable.monochrome)
    object Info : Screen("friendslist", R.string.text_info, com.example.designsystem.R.drawable.user_info)
}
