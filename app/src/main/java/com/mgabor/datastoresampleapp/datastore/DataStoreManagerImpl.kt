package com.mgabor.datastoresampleapp.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mgabor.datastoresampleapp.data.User
import com.mgabor.datastoresampleapp.UserPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManagerImpl @Inject constructor(
    @ApplicationContext val context: Context
) : DataStoreManager {

    private val Context.preferenceDataStore: DataStore<Preferences> by preferencesDataStore(
        name = "user"
    )
    private val Context.protoDataStore: DataStore<UserPreferences> by dataStore(
        fileName = "user.pb",
        serializer = UserSerializer
    )

    private val USER_FIRST_NAME = stringPreferencesKey("user_first_name")
    private val USER_LAST_NAME = stringPreferencesKey("user_last_name")
    private val USER_BIRTH_DAY = longPreferencesKey("user_birth_day")

    override suspend fun saveUserToPreferenceStore(user: User) {
        context.preferenceDataStore.edit { settings ->
            settings[USER_FIRST_NAME] = user.firstName
            settings[USER_LAST_NAME] = user.lastName
            settings[USER_BIRTH_DAY] = user.birthDay
        }
    }

    override fun getUserFromPreferenceStore(): Flow<User> = context.preferenceDataStore.data
        .map { preferences ->
            User(
                firstName = preferences[USER_FIRST_NAME] ?: "",
                lastName = preferences[USER_LAST_NAME] ?: "",
                birthDay = preferences[USER_BIRTH_DAY] ?: 0
            )
        }

    override suspend fun saveUserToProtoStore(user: User) {
        context.protoDataStore.updateData { currentUserData ->
            currentUserData.toBuilder()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setBirthDay(user.birthDay)
                .build()
        }
    }

    override fun getUserFromProtoStore(): Flow<User> =
        context.protoDataStore.data.map { settings ->
            User(
                firstName = settings.firstName,
                lastName = settings.lastName,
                birthDay = settings.birthDay
            )
        }
}
