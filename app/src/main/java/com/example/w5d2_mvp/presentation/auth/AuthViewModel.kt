package com.example.w5d2_mvp.presentation.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5d2_mvp.data.model.User
import com.example.w5d2_mvp.domain.usecase.SignInUseCase
import com.example.w5d2_mvp.domain.usecase.SignUpUseCase
import kotlinx.coroutines.launch

class AuthViewModel(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase

): ViewModel(){
    val signInState = mutableStateOf <Boolean?>(null)
    val signUpState = mutableStateOf <Boolean?>(null)

    fun signIn(email:String , password:String){
        viewModelScope.launch{
            signInState.value = signInUseCase.execute(email,password)
        }
    }
    fun signUp(user: User) {
        viewModelScope.launch {
            signUpState.value = signUpUseCase.execute(user)
        }
    }
}