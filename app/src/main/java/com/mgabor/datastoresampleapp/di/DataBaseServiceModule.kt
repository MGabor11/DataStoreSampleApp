package com.mgabor.datastoresampleapp.di

import android.content.Context
import androidx.room.Room
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
class DataBaseServiceModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): UserDatabase {
        return Room
            .databaseBuilder(context, UserDatabase::class.java, "user.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: UserDatabase): UserDao {
        return db.userDao()
    }
}