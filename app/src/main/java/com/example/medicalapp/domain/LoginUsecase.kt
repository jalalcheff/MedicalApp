package com.example.medicalapp.domain

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class LoginUsecase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend fun login(email: String, password: String):String{
        return loginRepository.login(email = email, password = password)
    }
}