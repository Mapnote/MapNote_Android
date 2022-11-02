package com.example.mapnote.todo

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.component.MapNoteBottom
import com.example.designsystem.component.MapNoteTextButtonView
import com.example.designsystem.component.MapNoteTodoView
import com.example.designsystem.theme.MapNoteTheme
import com.example.mapnote.model.Todo
import com.example.mapnote.model.previewTodoList

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun TodoScreen(todolist: List<Todo>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {

        val todoList = remember {
            mutableStateListOf<Todo>()
        }.also { it.addAll(todolist) }

        MapNoteBottom()
        Text(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 26.dp),
            text = "내 근처 Mapnote",
            color = MaterialTheme.colors.onBackground,
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = todoList, key = { notesList: Todo -> notesList.id }) { item ->

                val dismissState = rememberDismissState(
                    initialValue = DismissValue.Default
                )
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {

                    todoList.remove(item)
                }
                SwipeToDismiss(
                    state = dismissState, modifier = Modifier.animateItemPlacement(),
                    background = {
                        val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
                        val scale by animateFloatAsState(targetValue = if (dismissState.targetValue == DismissValue.Default) 0.8f else 1.0f)
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(end = 20.dp),
                            contentAlignment = Alignment.CenterEnd,
                        ) {
                            Image(
                                painter = if (dismissState.targetValue == DismissValue.Default) {
                                    painterResource(id = R.drawable.btn__delete_off)
                                } else {
                                    painterResource(id = R.drawable.btn__delete_on)
                                },
                                contentDescription = "todo 삭제",
                                modifier = Modifier.scale(scale)
                            )
                        }
                    },
                    directions = setOf(DismissDirection.EndToStart),
                    dismissThresholds = { FractionalThreshold(0.2f) }
                ) {
                    MapNoteTodoView(
                        modifier =
                        Modifier.border(
                            border = BorderStroke(
                                1.dp,
                                androidx.compose.material3.MaterialTheme.colorScheme.outline
                            ), shape = RoundedCornerShape(10.dp)
                        ),
                        stickerDrawableRes = R.drawable.sticker01,
                        labelText = item.label,
                        contentText = item.content
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun TodoWriteScreen(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        MapNoteBottom()
        Text(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 26.dp),
            text = text,
            color = MaterialTheme.colors.onBackground,
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )

        MapNoteTextButtonView(text = "text")

    }
}

@Preview(showBackground = true)
@Composable
fun TodoWriteScreenPreview() {
    val isWhatButtonClicked  by remember { mutableStateOf(false) }
    MapNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            TodoWriteScreen("CU 경희대점")
            Row() {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.btn_plus), contentDescription = "")
                }
                if (isWhatButtonClicked){
                    Text(text = "무엇을")
                }else{

                }
            }

        }
    }

    
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    MapNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            TodoScreen(todolist = previewTodoList)
        }
    }
}





