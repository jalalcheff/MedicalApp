package com.example.medicalapp.domain

import javax.inject.Inject

class SaveUidUsecase @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun saveUidUsecase(uid: String){
        sharedPreferencesRepository.saveUid(uid)
    }
}