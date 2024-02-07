package com.example.medicalapp.domain

import javax.inject.Inject

class GetAuthenticatedStatusUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun getAuthenticatedStatusUsecase(): Boolean{
        return sharedPreferencesRepository.isAuthenticated()
    }
}