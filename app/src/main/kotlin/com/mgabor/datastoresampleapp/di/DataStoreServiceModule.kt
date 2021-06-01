package com.mgabor.datastoresampleapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.mgabor.datastoresampleapp.UserPreferences
import com.mgabor.datastoresampleapp.datastore.UserSerializer
import com.mgabor.datastoresampleapp.db.UserDao
import com.mgabor.datastoresampleapp.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreServiceModule {

    private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
        name = "user"
    )

    private val Context.userProtoDataStore: DataStore<UserPreferences> by dataStore(
        fileName = "user.pb",
        serializer = UserSerializer
    )

    @Singleton
    @Provides
    fun provideUserPreferencesDataStore(
        @ApplicationContext app: Context
    ): DataStore<Preferences> = app.userPreferencesDataStore

    @Singleton
    @Provides
    fun provideUserProtoDataStore(
        @ApplicationContext app: Context
    ): DataStore<UserPreferences> = app.userProtoDataStore
}
