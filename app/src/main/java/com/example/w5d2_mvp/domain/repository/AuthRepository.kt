package com.example.w5d2_mvp.domain.repository

import com.example.w5d2_mvp.data.model.User

interface AuthRepository {
    fun signIn(email:String, password:String): Boolean
    fun signUp(user: User) : Boolean
}