package com.example.test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.test.viewmodel.UserDataViewModel

class UserDataActivity : AppCompatActivity() {
    private val viewModel: UserDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserDataScreen(viewModel = viewModel)
        }
    }
}