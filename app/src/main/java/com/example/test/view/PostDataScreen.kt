package com.example.test.view

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.model.User
import com.example.test.retrofit.RetrofitHelper
import com.example.test.utils.greenColor
import com.example.test.viewmodel.UserDataViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun PostDataScreen(viewModel: UserDataViewModel) {
    val ctx = LocalContext.current
    val id= remember {
        mutableStateOf(TextFieldValue())
    }
    val name = remember{
        mutableStateOf(TextFieldValue())
    }
    val email = remember{
        mutableStateOf(TextFieldValue())
    }
    val gender = remember{
        mutableStateOf(TextFieldValue())
    }
    val status = remember{
        mutableStateOf(TextFieldValue())
    }
    val response= remember {
        mutableStateOf("")
    }
    Column(modifier= Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Enter User Details",
        color= greenColor,
            fontSize = 20.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = id.value,
            label = { Text(text = "Enter Your Id") },
            onValueChange = {
                id.value = it
            },
                    modifier = Modifier
                    .padding(16.dp)
                .fillMaxWidth(),

            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        TextField(
            value = name.value,
            label = { Text(text = "Enter Your Name") },
            onValueChange = {
                name.value = it
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = email.value,
            label = { Text(text = "Enter Your Email") },
            onValueChange = {
                email.value = it
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = gender.value,
            label = { Text(text = "Enter Your Gender") },
            onValueChange = {
                gender.value = it
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = status.value,
            label = { Text(text = "Enter Your Status") },
            onValueChange = {
                status.value = it
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {

                postDataUsingRetrofit(
                    ctx, id,name, email,gender,status, response
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Post Data", modifier = Modifier.padding(8.dp))
        }
        Button(
            onClick = {
                val intent = Intent(ctx,UserDataActivity::class.java)
                ctx.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Text(text = "Get List", modifier = Modifier.padding(8.dp))

        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = response.value,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )


    }

}

 fun postDataUsingRetrofit(ctx: Context, id: MutableState<TextFieldValue>, name: MutableState<TextFieldValue>, email: MutableState<TextFieldValue>, gender: MutableState<TextFieldValue>, status: MutableState<TextFieldValue>, result: MutableState<String>) {
    val retrofit=RetrofitHelper.userData

    val userData = User(id.value.text.toInt(),name.value.text,email.value.text,gender.value.text,status.value.text)
    val call: Call<User?>? = retrofit.postData(userData)
    call!!.enqueue(object : Callback<User?>{
        override fun onResponse(call: Call<User?>, response: Response<User?>) {
            Toast.makeText(ctx, "Data posted to API", Toast.LENGTH_SHORT).show()

            val model: User? = response.body()

            val resp =
                "Response Code : " + response.code() + "\n" + "User Name : " + model!!.name + "\n" + "Email : " + model!!.email
            result.value = resp
        }

        override fun onFailure(call: Call<User?>, t: Throwable) {
            result.value = "Error found is : " + t.message
        }

    })


}
