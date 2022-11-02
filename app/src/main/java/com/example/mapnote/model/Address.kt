package com.example.mapnote.model

data class Address(
    val id: Int,
    val address: String,
    val roadAddress: String,
)

val previewAddressList = listOf(
    Address(id = 0, address = "경희대학교 서울캠퍼스", roadAddress = "서울특별시 동대문구 경희대로 26"),
    Address(id = 1, address = "경희대학교 국제캠퍼스", roadAddress = "경기도 용인시 기흥구 덕영대로 1732 경..."),
    Address(id = 2, address = "경희대학교 국제캠퍼스 국제대학원", roadAddress = "경기도 용인시 기흥구 덕영대로 1732"),
    Address(id = 3, address = "경희대학교 국제캠퍼스 도서관", roadAddress = "경기도 용인시 기흥구 덕영대로 1732 경..."),
    Address(id = 4, address = "경희대학교 평화복지대학원", roadAddress = "경기도 남양주시 진접읍 광릉수목원로 1")
)



