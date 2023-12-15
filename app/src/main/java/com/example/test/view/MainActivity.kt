package com.example.test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.test.retrofit.RetrofitHelper
import com.example.test.retrofit.UserApi
import com.example.test.view.PostDataScreen
import com.example.test.view.UserDataScreen
import com.example.test.viewmodel.UserDataViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel:UserDataViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
setContent {

    PostDataScreen(viewModel = viewModel)
}

    }
}