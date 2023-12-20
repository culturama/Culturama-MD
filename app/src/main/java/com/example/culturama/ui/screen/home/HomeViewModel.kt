package com.example.culturama.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.culturama.data.manager.CultureRepository
import com.example.culturama.model.FavCulture
import com.example.culturama.ui.screen.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repository: CultureRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<FavCulture>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<FavCulture>>> get() = _uiState

    fun getAllCulture() {
        viewModelScope.launch {
            repository.getAllCulture()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {favGames ->
                    _uiState.value = UiState.Success(favGames)
                }
        }
    }
}
