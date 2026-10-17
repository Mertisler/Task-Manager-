
package com.loc.taskmanager.domain.repository

import com.loc.taskmanager.core.common.AppResult
import com.loc.taskmanager.domain.model.Board
import com.loc.taskmanager.domain.model.BoardColumn
import kotlinx.coroutines.flow.Flow

interface BoardRepository {

    fun observeBoards(
        projectId: String
    ): Flow<List<Board>>

    fun observeColumns(
        boardId: String
    ): Flow<List<BoardColumn>>

    suspend fun createBoard(
        board: Board
    ): AppResult<Unit>

    suspend fun createColumn(
        column: BoardColumn
    ): AppResult<Unit>

    suspend fun updateColumn(
        column: BoardColumn
    ): AppResult<Unit>

    suspend fun deleteColumn(
        columnId: String
    ): AppResult<Unit>
}
