package com.mgabor.datastoresampleapp.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.mgabor.datastoresampleapp.UserPreferences
import com.mgabor.datastoresampleapp.data.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManagerImpl @Inject constructor(
    private val userPreferencesDataStore: DataStore<Preferences>,
    private val userProtoDataStore: DataStore<UserPreferences>
) : DataStoreManager {

    private val USER_FIRST_NAME = stringPreferencesKey("user_first_name")
    private val USER_LAST_NAME = stringPreferencesKey("user_last_name")
    private val USER_BIRTH_DAY = longPreferencesKey("user_birth_day")

    override suspend fun saveUserToPreferenceStore(user: User) {
        userPreferencesDataStore.edit { preferences ->
            preferences[USER_FIRST_NAME] = user.firstName
            preferences[USER_LAST_NAME] = user.lastName
            preferences[USER_BIRTH_DAY] = user.birthDay
        }
    }

    override fun getUserFromPreferenceStore(): Flow<User> = userPreferencesDataStore.data
        .map { preferences ->
            User(
                firstName = preferences[USER_FIRST_NAME] ?: "",
                lastName = preferences[USER_LAST_NAME] ?: "",
                birthDay = preferences[USER_BIRTH_DAY] ?: 0
            )
        }

    override suspend fun saveUserToProtoStore(user: User) {
        userProtoDataStore.updateData { currentUserData ->
            currentUserData.toBuilder()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setBirthDay(user.birthDay)
                .build()
        }
    }

    override fun getUserFromProtoStore(): Flow<User> =
        userProtoDataStore.data.map { user ->
            User(
                firstName = user.firstName,
                lastName = user.lastName,
                birthDay = user.birthDay
            )
        }
}
