package com.mgabor.datastoresampleapp.service

import com.mgabor.datastoresampleapp.data.User
import com.mgabor.datastoresampleapp.datastore.DataStoreManager
import com.mgabor.datastoresampleapp.db.UserDao
import com.mgabor.datastoresampleapp.db.UserDataModel
import com.mgabor.datastoresampleapp.sharedpref.SharedPreferencesManager
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserServiceImpl @Inject constructor(
    private val userDao: UserDao,
    private val sharedPreferencesManager: SharedPreferencesManager,
    private val dataStoreManager: DataStoreManager
) : UserService {

    override fun getUser(): Flow<User> = getUserFromProtoDataStore()

    override fun getUserFromSharedPreferences() = sharedPreferencesManager.getUser()

    override fun getUserFromDB() =
        userDao.getUsers().filter { it.isNotEmpty() }
            .flatMapConcat {
                userDao.getUser()
                    .map {
                        User(
                            id = it.id,
                            firstName = it.firstName,
                            lastName = it.lastName,
                            birthDay = it.birthDay
                        )
                    }
            }


    override fun getUserFromPreferencesDataStore() = dataStoreManager.getUserFromPreferencesStore()

    override fun getUserFromProtoDataStore() = dataStoreManager.getUserFromProtoStore()

    override suspend fun addUser(user: User) {
        //Add to SharedPreferences
        sharedPreferencesManager.saveUser(user)

        //Add to DB
        userDao.insert(
            UserDataModel(
                firstName = user.firstName,
                lastName = user.lastName,
                birthDay = user.birthDay
            )
        )
        //Add to Preference DataStore
        dataStoreManager.saveUserToPreferencesStore(user)

        //Add to Proto DataStore
        dataStoreManager.saveUserToProtoStore(user)
    }
}
