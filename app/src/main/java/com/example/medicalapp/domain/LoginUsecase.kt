package com.example.medicalapp.domain

import javax.inject.Inject

class LoginUsecase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend fun login(email: String, password: String):String{
        return loginRepository.login(email = email, password = password)
    }
}