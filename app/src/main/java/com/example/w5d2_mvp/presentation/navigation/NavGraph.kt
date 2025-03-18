package com.example.w5d2_mvp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.w5d2_mvp.presentation.auth.AuthViewModel
import com.example.w5d2_mvp.presentation.auth.SignInScreen
import com.example.w5d2_mvp.presentation.auth.SignUpScreen

@Composable
fun NavGraph(viewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "signIn") {
        composable("signIn") {
            SignInScreen(viewModel, onNavigateToSignUp = { navController.navigate("signUp") })
        }
        composable("signUp") {
            SignUpScreen(viewModel, onNavigateToSignIn = { navController.navigate("signIn") })
        }
    }
}