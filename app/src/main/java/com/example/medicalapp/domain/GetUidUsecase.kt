package com.example.medicalapp.domain

import javax.inject.Inject

class GetUidUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun getUidUsecase(): String{
        return sharedPreferencesRepository.getUid()
    }
}