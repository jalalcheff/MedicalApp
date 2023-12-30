package com.example.medicalapp.ui.screen.loginScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.medicalapp.domain.GetCurrentSevenDays
import com.example.medicalapp.domain.GetNextSevenDaysUsecase
import com.example.medicalapp.domain.LoginUsecase
import com.google.android.gms.tasks.Tasks.await
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel

class LoginViewModel @Inject constructor(
    private val loginUsecase: LoginUsecase,
    private val getCurrentSevenDays: GetCurrentSevenDays
    ): ViewModel() {
    init {
        getCurrentSevenDays.getCurrentSevenDay()
    }
    private val _userData = MutableStateFlow(LoginUiState())
    val userData = _userData.asStateFlow()
    suspend fun login(email: String, password: String) {
        try {
            val uid = loginUsecase.login(email, password)
            Log.i("jalal", "email is $email uid is $uid")
            _userData.update {
                it.copy(
                    username = email,
                    password = password,
                    uid = uid,
                    exception = false
                )
            }
        }
        catch (e: Exception){
            Log.i("loginEx", e.message.toString())
        }

    }
    fun getData(){
        _userData.value.uid
    }
}