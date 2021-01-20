package com.mgabor.datastoresampleapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mgabor.coroutine.util.asLiveDataOnDefault
import com.mgabor.datastoresampleapp.data.User
import com.mgabor.datastoresampleapp.data.UserDataSource
import com.mgabor.datastoresampleapp.service.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    userService: UserService
    ) : ViewModel() {

    val userList: LiveData<List<Pair<UserDataSource, User>>> = combine(
        userService.getUserFromDB(),
        userService.getUserFromPreferencesDataStore(),
        userService.getUserFromProtoDataStore(),
        userService.getUserFromSharedPreferences()
    ) { fromDB, fromPreferencesDataStore, fromProtoDataStore, fromSharedPreferences ->
        listOf(
            UserDataSource.ROOM to fromDB,
            UserDataSource.PREFERENCE_DATA_STORE to fromPreferencesDataStore,
            UserDataSource.PROTO_DATA_STORE to fromProtoDataStore,
            UserDataSource.SHARED_PREFERENCES to fromSharedPreferences
        )
    }.asLiveDataOnDefault()
}
