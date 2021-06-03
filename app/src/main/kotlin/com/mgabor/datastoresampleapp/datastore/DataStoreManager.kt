package com.mgabor.datastoresampleapp.datastore

import com.mgabor.datastoresampleapp.data.User
import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    suspend fun saveUserToPreferencesStore(user: User)
    fun getUserFromPreferencesStore(): Flow<User>
    suspend fun saveUserToProtoStore(user: User)
    fun getUserFromProtoStore(): Flow<User>
}
