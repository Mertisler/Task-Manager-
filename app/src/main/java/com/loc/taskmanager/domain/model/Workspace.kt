package com.loc.taskmanager.domain.model

data class Workspace(
    val id: String,
    val name: String,
    val description: String = "",
    val ownerId: String,
    val memberIds: List<String> = emptyList()
)
