package com.mgabor.datastoresampleapp.sharedpref

import com.mgabor.datastoresampleapp.data.User
import kotlinx.coroutines.flow.Flow

interface SharedPreferencesManager {
    fun saveUser(user: User)
    fun getUser(): User
}
