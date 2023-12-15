package com.example.test.viewmodel

import com.example.test.model.User
import com.example.test.retrofit.RetrofitHelper

class UserRepository {
    private val  userApi=RetrofitHelper.userData
    suspend fun getUserData():List<User>
    {
        return userApi.getUsers()
    }
}