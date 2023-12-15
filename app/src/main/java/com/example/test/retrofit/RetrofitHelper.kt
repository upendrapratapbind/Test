package com.example.test.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
   private const val BASE_URL="https://gorest.co.in/public/v2/"
    private val retrofit:Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val userData:UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }
    }
