package com.example.medicalapp.domain

import javax.inject.Inject

class GetPasswordUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun getPasswordUsecase(): String{
        return sharedPreferencesRepository.getPassword()
    }
}