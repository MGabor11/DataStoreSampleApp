package com.mgabor.datastoresampleapp.service

import com.mgabor.datastoresampleapp.data.User
import kotlinx.coroutines.flow.Flow

interface UserService {

    fun getUser(): Flow<User>

    fun getUserFromSharedPreferences(): User

    fun getUserFromDB(): Flow<User>

    fun getUserFromPreferencesDataStore(): Flow<User>

    fun getUserFromProtoDataStore(): Flow<User>

    suspend fun addUser(user: User)
}
