package com.example.test.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.test.viewmodel.UserDataViewModel

@Composable
fun UserDataScreen(viewModel:UserDataViewModel) {
   val userDatas by viewModel.userList.observeAsState(emptyList())
    LaunchedEffect(Unit){
        viewModel.fetchUserData()
    }
    Column(modifier = Modifier.padding(horizontal = 8.dp)){

        if (userDatas.isEmpty()){
           Text(text="Loading...")
        }
        else{
            LazyColumn{items(userDatas) { userData->
                Text(text = userData.id.toString())

                Text(text = userData.name, color = Color.Red)
                Text(text = userData.email)
                Text(text = userData.gender)
                Text(text = userData.status)
                Divider()
            }
            }
        }
    }
}