package com.example.w5d2_mvp.domain.usecase

import com.example.w5d2_mvp.data.model.User
import com.example.w5d2_mvp.domain.repository.AuthRepository

class SignUpUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(user: User):Boolean{
        return authRepository.signUp(user)
    }
}