package com.example.medicalapp.domain

import javax.inject.Inject

class SetAuthenticatedStatusUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun setAuthenticatedStatusUsecase(isAuthenticate: Boolean){
        sharedPreferencesRepository.setAuthenticatedStatus(isAuthenticate = isAuthenticate)
    }
}