package com.example.test.retrofit

import com.example.test.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<User>
    @POST("users")
    fun postData(@Body userData: User?): Call<User?>?
}