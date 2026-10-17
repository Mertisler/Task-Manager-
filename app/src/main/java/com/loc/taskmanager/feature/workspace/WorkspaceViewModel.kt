package com.loc.taskmanager.feature.workspace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.taskmanager.domain.repository.WorkspaceRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class WorkspaceViewModel(
    private val workspaceRepository: WorkspaceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WorkspaceUiState())
    val uiState = _uiState.asStateFlow()

    private var observeJob: Job? = null

    fun observeWorkspaces(userId: String) {
        if (userId.isBlank()) {
            _uiState.value = WorkspaceUiState(
                errorMessage = "Kullanıcı bilgisi bulunamadı."
            )
            return
        }

        observeJob?.cancel()

        observeJob = viewModelScope.launch {
            workspaceRepository
                .observeUserWorkspaces(userId)
                .onStart {
                    _uiState.value = _uiState.value.copy(
                        isLoading = true,
                        errorMessage = null
                    )
                }
                .catch { throwable ->
                    if (throwable is CancellationException) {
                        throw throwable
                    }

                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = "Çalışma alanları yüklenemedi."
                    )
                }
                .collect { workspaces ->
                    _uiState.value = WorkspaceUiState(
                        isLoading = false,
                        workspaces = workspaces
                    )
                }
        }
    }
}
