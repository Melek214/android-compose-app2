package com.example.jetpackegitim2

import com.example.jetpackegitim2.ui.users.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideUserRepository(): UserRepository{
        return UserRepository()
    }

}