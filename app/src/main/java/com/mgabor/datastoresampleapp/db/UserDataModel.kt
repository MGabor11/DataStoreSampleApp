package com.mgabor.datastoresampleapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDataModel(
    @PrimaryKey val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val birthDay: Long
)
