package com.loc.taskmanager.domain.model

data class Project(
    val id: String,
    val workspaceId: String,
    val name: String,
    val description: String = "",
    val createdBy: String
)
