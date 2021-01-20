package com.mgabor.datastoresampleapp.di

import com.mgabor.datastoresampleapp.datastore.DataStoreManager
import com.mgabor.datastoresampleapp.datastore.DataStoreManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreManagerModule {

    @Singleton
    @Binds
    abstract fun bindDataStoreService(impl: DataStoreManagerImpl): DataStoreManager
}
