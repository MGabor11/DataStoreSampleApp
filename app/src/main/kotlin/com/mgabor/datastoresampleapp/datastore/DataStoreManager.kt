package com.mgabor.datastoresampleapp.datastore

import com.mgabor.datastoresampleapp.data.User
import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    suspend fun saveUserToPreferenceStore(user: User)
    fun getUserFromPreferenceStore(): Flow<User>
    suspend fun saveUserToProtoStore(user: User)
    fun getUserFromProtoStore(): Flow<User>
}
