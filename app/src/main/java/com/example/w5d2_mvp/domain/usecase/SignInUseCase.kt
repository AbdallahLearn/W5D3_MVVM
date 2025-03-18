package com.example.w5d2_mvp.domain.usecase

import com.example.w5d2_mvp.domain.repository.AuthRepository

class SignInUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(email:String, password:String):Boolean {
        return authRepository.signIn(email,password)
    }
}