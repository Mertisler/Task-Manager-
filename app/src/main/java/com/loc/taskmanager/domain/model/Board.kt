package com.loc.taskmanager.domain.model

data class Board(
    val id: String,
    val projectId: String,
    val name: String,
    val description: String = ""
)
