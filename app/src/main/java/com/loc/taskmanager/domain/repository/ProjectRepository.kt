package com.loc.taskmanager.domain.repository

import com.loc.taskmanager.core.common.AppResult
import com.loc.taskmanager.domain.model.Project
import kotlinx.coroutines.flow.Flow

interface ProjectRepository {

    fun observeProjects(
        workspaceId: String
    ): Flow<List<Project>>

    suspend fun createProject(
        project: Project
    ): AppResult<Unit>

    suspend fun updateProject(
        project: Project
    ): AppResult<Unit>

    suspend fun deleteProject(
        projectId: String
    ): AppResult<Unit>
}
