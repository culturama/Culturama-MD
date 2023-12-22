package com.example.culturama.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.culturama.data.manager.CultureRepositoryLocal
import com.example.culturama.domain.model.FavCulture
import com.example.culturama.ui.screen.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CultureRepositoryLocal) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<FavCulture>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<FavCulture>>> get() = _uiState

    fun getAllCulture() {
        viewModelScope.launch {
            try {
                repository.getAllCulture().collect { favGames ->
                    _uiState.value = UiState.Success(favGames)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to retrieve culture data: ${e.message}")
            }
        }
    }
}