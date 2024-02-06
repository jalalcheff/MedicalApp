package com.example.medicalapp.domain

import javax.inject.Inject

class SaveUsernameUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun saveUsernameUsecase(username: String){
        sharedPreferencesRepository.saveUsername(username)
    }
}