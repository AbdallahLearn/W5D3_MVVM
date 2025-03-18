package com.example.w5d2_mvp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.w5d2_mvp.data.repository.AuthRepositoryImpl
import com.example.w5d2_mvp.domain.usecase.SignInUseCase
import com.example.w5d2_mvp.domain.usecase.SignUpUseCase
import com.example.w5d2_mvp.presentation.auth.AuthViewModel
import com.example.w5d2_mvp.presentation.auth.AuthViewModelFactory
import com.example.w5d2_mvp.presentation.navigation.NavGraph
import com.example.w5d2_mvp.ui.theme.Pink40
import com.example.w5d2_mvp.ui.theme.Purple40
import com.example.w5d2_mvp.ui.theme.PurpleGrey40
import com.example.w5d2_mvp.ui.theme.W5D2_MVPTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegistrationAppTheme {
                // Initialize dependencies
                val authRepository = AuthRepositoryImpl()
                val signInUseCase = SignInUseCase(authRepository)
                val signUpUseCase = SignUpUseCase(authRepository)
                val viewModelFactory = AuthViewModelFactory(signInUseCase, signUpUseCase)

                // Use the custom ViewModel factory
                val viewModel: AuthViewModel = viewModel(factory = viewModelFactory)

                // Start the navigation graph
                NavGraph(viewModel = viewModel)
            }
        }
    }
}

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun RegistrationAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}