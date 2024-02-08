package com.example.medicalapp.domain

import javax.inject.Inject

class ChangePasswordUsecase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend fun changePasswordUsecase(password: String){
        loginRepository.changePassword(password)
    }
}