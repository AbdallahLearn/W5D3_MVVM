package com.example.w5d2_mvp.presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.w5d2_mvp.data.model.User

@Composable
fun SignUpScreen(viewModel: AuthViewModel, onNavigateToSignIn: ()-> Unit){
    var name by remember{ mutableStateOf("")}
    var email by remember{ mutableStateOf("")}
    var password by remember{ mutableStateOf("")}
    var confirmPassword by remember{ mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ){
        Text(
            text ="Sign Up Page",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = confirmPassword, onValueChange = {confirmPassword =it} , label = {Text(text = "Confirm Password")})
        Spacer(modifier = Modifier.height(10.dp))


        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            onClick = {
            if (password == confirmPassword) {
                viewModel.signUp(User(name, email, password))
            }
        }) {
            Text("Sign Up")
        }
        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            onClick = onNavigateToSignIn) {
            Text("Go to Sign In")
        }
    }

}