package com.mgabor.datastoresampleapp.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Database(entities = [UserDataModel::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}

@Dao
abstract class UserDao {

    companion object {
        private const val DEFAULT_USER_ID = 0
    }

    @Query("SELECT * FROM user")
    abstract fun getUsers(): Flow<List<UserDataModel>>

    @Query("SELECT * FROM user WHERE id = :userId")
    abstract fun getUser(userId: Int = DEFAULT_USER_ID): Flow<UserDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(item: UserDataModel)
}
