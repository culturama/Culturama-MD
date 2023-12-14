package com.example.culturama.di

import android.app.Application
import com.example.culturama.data.manager.LocalUserManagerImplementation
import com.example.culturama.domain.manager.LocalUserManager
import com.example.culturama.domain.usecases.AppEntryUseCases
import com.example.culturama.domain.usecases.ReadAppEntry
import com.example.culturama.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImplementation(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}