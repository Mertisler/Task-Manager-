
package com.loc.taskmanager.core.common

sealed interface AppError {

    data class Network(
        val message: String
    ) : AppError

    data class Validation(
        val message: String
    ) : AppError

    data object Unauthorized : AppError

    data object NotFound : AppError

    data object Conflict : AppError

    data class Unknown(
        val message: String
    ) : AppError
}
