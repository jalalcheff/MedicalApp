package com.example.medicalapp.domain

import javax.inject.Inject

class GetUsernameUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun getUsernameUsecase(): String{
        return sharedPreferencesRepository.getUserName()
    }
}