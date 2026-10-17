package com.loc.taskmanager.domain.model

data class BoardColumn(
    val id: String,
    val boardId: String,
    val title: String,
    val position: Double
)
