package com.example.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.User
import kotlinx.coroutines.launch

class UserDataViewModel: ViewModel() {
    private val userRepository= UserRepository()
    private val _userList= MutableLiveData<List<User>>()
    val  userList:LiveData<List<User>> = _userList
    fun fetchUserData(){
        viewModelScope.launch {

            try {
                val user=userRepository.getUserData()
                _userList.value=user

            }catch (e:Exception){
                 println(e.localizedMessage)
            }
        }
    }
}