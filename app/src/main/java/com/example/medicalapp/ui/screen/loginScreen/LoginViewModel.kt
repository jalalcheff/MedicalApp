package com.example.medicalapp.ui.screen.loginScreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.medicalapp.domain.LoginUsecase
import com.google.android.gms.tasks.Tasks.await
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel

class LoginViewModel @Inject constructor(private val loginUsecase: LoginUsecase) : ViewModel() {

    private val _userData = MutableStateFlow(LoginUiState())
    val userData = _userData.asStateFlow()
    suspend fun login(email: String, password: String) {
        val uid = loginUsecase.login(email, password)
        delay(8000)
        Log.i("jalal", "email is $email uid is $uid")
        _userData.update {
            it.copy(
                username = email,
                password = password,
                uid = uid
            )
        }
        /* if (loginUsecase.login(email, password) != "invalid")
             TODO("navigate to the other screen")
             else
                 TODO("show invalid message")*/
    }
    fun getData(){
        Log.i("jalal", "${_userData.value}")
    }
}