package com.mgabor.datastoresampleapp.ui.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgabor.datastoresampleapp.data.User
import com.mgabor.datastoresampleapp.service.UserService
import com.mgabor.datastoresampleapp.util.launchOnDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val birthDay = MutableLiveData<Long>()

    fun saveData(){
        viewModelScope.launchOnDefault {
            userService.addUser(User(
                firstName = firstName.value!!,
                lastName = lastName.value!!,
                birthDay = birthDay.value!!
            ))
        }
    }
}
