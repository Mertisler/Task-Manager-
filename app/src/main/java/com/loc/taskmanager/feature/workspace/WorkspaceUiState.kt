package com.loc.taskmanager.feature.workspace

import com.loc.taskmanager.domain.model.Workspace

data class WorkspaceUiState(
    val isLoading: Boolean = false,
    val workspaces: List<Workspace> = emptyList(),
    val errorMessage: String? = null
)
