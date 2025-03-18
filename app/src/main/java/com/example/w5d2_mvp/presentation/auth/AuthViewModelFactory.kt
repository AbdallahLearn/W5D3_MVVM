package com.example.w5d2_mvp.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.w5d2_mvp.domain.usecase.SignInUseCase
import com.example.w5d2_mvp.domain.usecase.SignUpUseCase

class AuthViewModelFactory(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(signInUseCase, signUpUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}