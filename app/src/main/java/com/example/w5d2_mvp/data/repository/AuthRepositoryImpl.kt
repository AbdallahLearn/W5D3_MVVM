package com.example.w5d2_mvp.data.repository

import com.example.w5d2_mvp.data.model.User
import com.example.w5d2_mvp.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override fun signIn(email: String, password: String): Boolean {
        // Simulate network call or database check
        return email == "test@example.com" && password == "password"
    }

    override fun signUp(user: User): Boolean {
        // Simulate network call or database save
        return true
    }
}