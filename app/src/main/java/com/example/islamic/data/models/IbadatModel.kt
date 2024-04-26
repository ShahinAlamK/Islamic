package com.example.islamic.data.models

data class ItemModel(
    val title: String = "",
    val items: List<IbadatModel> = emptyList()
)

data class IbadatModel(
    var title: String = "",
    val bangla: String = "",
    var arabic: String = "",
    var meaning: String = ""
)




