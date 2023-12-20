package com.example.culturama.ui.screen.fav

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavViewModel : ViewModel() {
    private val _favoriteLocations = MutableLiveData<List<FavouriteData>>()
    val favoriteLocations: LiveData<List<FavouriteData>> get() = _favoriteLocations
    init {
        // disini menginisialisasi _favoriteLocations jika diperlukan
        // Misalnya, mengambil data dari sumber eksternal atau menyimpannya di shared preferences.
        _favoriteLocations.value = emptyList()
    }
    fun addToFavorites(favoriteData: FavouriteData) {
        val currentList = _favoriteLocations.value.orEmpty().toMutableList()
        if (!currentList.contains(favoriteData)) {
            currentList.add(favoriteData)
            _favoriteLocations.value = currentList
        }
    }
    fun removeFromFavorites(favoriteData: FavouriteData) {
        val currentList = _favoriteLocations.value.orEmpty().toMutableList()
        if (currentList.contains(favoriteData)) {
            currentList.remove(favoriteData)
            _favoriteLocations.value = currentList
        }
    }
}
@Composable
fun ProvideFavViewModel(content: @Composable (FavViewModel) -> Unit) {
    val viewModel: FavViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    content(viewModel)
}
