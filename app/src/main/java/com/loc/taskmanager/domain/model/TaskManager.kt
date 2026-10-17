package com.loc.taskmanager.domain.model

data class TaskCard(
    val id: String,
    val boardId: String,
    val columnId: String,
    val title: String,
    val description: String = "",
    val position: Double = 0.0,
    val assigneeIds: List<String> = emptyList(),
    val labelIds: List<String> = emptyList(),
    val version: Long = 0L
)
