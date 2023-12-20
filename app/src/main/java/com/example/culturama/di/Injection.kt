package com.example.culturama.di

import com.example.culturama.data.manager.CultureRepository

object Injection {
    fun provideRepository(): CultureRepository {
        return CultureRepository.getInstance()
    }
}