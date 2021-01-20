package com.mgabor.datastoresampleapp.di

import com.mgabor.datastoresampleapp.service.UserService
import com.mgabor.datastoresampleapp.service.UserServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserServiceModule {

    @Singleton
    @Binds
    abstract fun bindUserService(impl: UserServiceImpl): UserService
}
