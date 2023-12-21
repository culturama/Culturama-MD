package com.example.culturama.ui.screen.survei

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SurveiViewModel : ViewModel() {

    // Gunakan MutableStateFlow untuk data rating
    private val _monasRating = MutableStateFlow(0)
    val monasRating: StateFlow<Int> = _monasRating

    private val _tamanFantasiRating = MutableStateFlow(0)
    val tamanFantasiRating: StateFlow<Int> = _tamanFantasiRating

    private val _ragunanZooRating = MutableStateFlow(0)
    val ragunanZooRating: StateFlow<Int> = _ragunanZooRating

    private val _ancolBeachRating = MutableStateFlow(0)
    val ancolBeachRating: StateFlow<Int> = _ancolBeachRating

    private val _grandIndoRating = MutableStateFlow(0)
    val grandIndoRating: StateFlow<Int> = _grandIndoRating

    private val _istiqlalRating = MutableStateFlow(0)
    val istiqlalRating: StateFlow<Int> = _istiqlalRating

    // Fungsi untuk mengubah rating
    fun setMonasRating(rating: Int) {
        viewModelScope.launch {
            _monasRating.emit(rating)
        }
    }

    fun setTamanFantasiRating(rating: Int) {
        viewModelScope.launch {
            _tamanFantasiRating.emit(rating)
        }
    }

    fun setRagunanZooRating(rating: Int) {
        viewModelScope.launch {
            _ragunanZooRating.emit(rating)
        }
    }

    fun setAncolBeachRating(rating: Int) {
        viewModelScope.launch {
            _ancolBeachRating.emit(rating)
        }
    }

    fun setGrandIndoRating(rating: Int) {
        viewModelScope.launch {
            _grandIndoRating.emit(rating)
        }
    }

    fun setIstiqlalRating(rating: Int) {
        viewModelScope.launch {
            _istiqlalRating.emit(rating)
        }
    }
}
