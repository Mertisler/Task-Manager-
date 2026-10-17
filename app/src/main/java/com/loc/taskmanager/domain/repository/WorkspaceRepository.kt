package com.loc.taskmanager.domain.repository

import com.loc.taskmanager.core.common.AppResult
import com.loc.taskmanager.domain.model.Workspace
import kotlinx.coroutines.flow.Flow

interface WorkspaceRepository {

    fun observeUserWorkspaces(
        userId: String
    ): Flow<List<Workspace>>

    suspend fun createWorkspace(
        workspace: Workspace
    ): AppResult<Unit>

    suspend fun updateWorkspace(
        workspace: Workspace
    ): AppResult<Unit>

    suspend fun deleteWorkspace(
        workspaceId: String
    ): AppResult<Unit>
}
