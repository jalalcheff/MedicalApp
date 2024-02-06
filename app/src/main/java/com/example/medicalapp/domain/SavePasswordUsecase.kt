package com.example.medicalapp.domain

import javax.inject.Inject

class SavePasswordUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun savePasswordUsecase(password: String){
        sharedPreferencesRepository.savePassword(password)
    }
}