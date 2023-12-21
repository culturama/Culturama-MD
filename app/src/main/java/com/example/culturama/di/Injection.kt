package com.example.culturama.di

import com.example.culturama.data.manager.CultureRepositoryLocal

object Injection {
    fun provideRepository(): CultureRepositoryLocal {
        return CultureRepositoryLocal.getInstance()
    }
}