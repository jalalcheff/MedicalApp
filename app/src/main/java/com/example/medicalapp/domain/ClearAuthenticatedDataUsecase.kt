package com.example.medicalapp.domain

import javax.inject.Inject

class ClearAuthenticatedDataUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun clearAuthenticatedDataUsecase(){
        sharedPreferencesRepository.clearAuthenticatedData()
    }
}