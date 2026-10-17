package com.loc.taskmanager.domain.repository

import com.loc.taskmanager.core.common.AppResult
import com.loc.taskmanager.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun observeAuthState(): Flow<User?>

    suspend fun login(
        email: String,
        password: String
    ): AppResult<User>

    suspend fun register(
        displayName: String,
        email: String,
        password: String
    ): AppResult<User>

    suspend fun logout(): AppResult<Unit>
}
