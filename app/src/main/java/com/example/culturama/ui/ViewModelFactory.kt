package com.example.culturama.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.culturama.data.manager.CultureRepository
import com.example.culturama.ui.screen.home.HomeViewModel

class ViewModelFactory (private val repository: CultureRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
//        } else if (modelClass.isAssignableFrom(DetailGameViewModel::class.java)) {
//            return DetailGameViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}