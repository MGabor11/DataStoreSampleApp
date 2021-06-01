package com.mgabor.datastoresampleapp.di

import com.mgabor.datastoresampleapp.sharedpref.SharedPreferencesManager
import com.mgabor.datastoresampleapp.sharedpref.SharedPreferencesManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SharedPreferencesManagerModule {

    @Singleton
    @Binds
    abstract fun bindSharedPreferencesManager(
        impl: SharedPreferencesManagerImpl
    ): SharedPreferencesManager
}
