package com.mgabor.datastoresampleapp.sharedpref

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.mgabor.datastoresampleapp.data.User
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesManagerImpl @Inject constructor(
    @ApplicationContext context: Context
) : SharedPreferencesManager {

    private val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)

    override fun saveUser(user: User) {
        sharedPref.edit {
            putString(PREF_FIRST_NAME, user.firstName)
            putString(PREF_LAST_NAME, user.lastName)
            putLong(PREF_BIRTH_DAY, user.birthDay)
        }
    }

    override fun getUser(): User {
        val firstName = sharedPref.getString(PREF_FIRST_NAME, "")
        val lastName = sharedPref.getString(PREF_LAST_NAME, "")
        val birthDay = sharedPref.getLong(PREF_BIRTH_DAY, 0)

        return User(firstName = firstName ?: "", lastName = lastName ?: "", birthDay = birthDay)
    }

    companion object {
        private const val PREF_FIRST_NAME = "PREF_FIRST_NAME"
        private const val PREF_LAST_NAME = "PREF_LAST_NAME"
        private const val PREF_BIRTH_DAY = "PREF_BIRTH_DAY"
    }
}
