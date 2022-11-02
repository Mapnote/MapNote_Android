package com.example.mapnote.model

data class Todo(
     val id: Int,
     val content: String,
     val label: String
)

val previewTodoList = listOf(
    Todo(id = 0, content = "은이랑 놀기", label = "cu 경희대점"),
    Todo(id = 1, content = "아기랑 수영하기", label = "낙성대 수영센터"),
    Todo(id = 2, content = "박하랑 서핑 강습받기", label = "속초 수영장")
)