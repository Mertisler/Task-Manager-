
package com.loc.taskmanager.domain.repository

import com.loc.taskmanager.core.common.AppResult
import com.loc.taskmanager.domain.model.TaskCard
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun observeTasks(
        boardId: String
    ): Flow<List<TaskCard>>

    suspend fun createTask(
        task: TaskCard
    ): AppResult<Unit>

    suspend fun updateTask(
        task: TaskCard
    ): AppResult<Unit>

    suspend fun deleteTask(
        taskId: String
    ): AppResult<Unit>
}
