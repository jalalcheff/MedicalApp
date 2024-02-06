package com.example.medicalapp.repository

import com.example.medicalapp.domain.SharedPreferencesRepository
import javax.inject.Inject

class SharedPreferencesRepositoryImp @Inject constructor(private val sharedPreferenceService: SharedPreferenceService): SharedPreferencesRepository {
    override fun saveUsername(userName: String) {
        sharedPreferenceService.saveUserName(userName)
    }

    override fun savePassword(password: String) {
        sharedPreferenceService.savePassword(password)
    }

    override fun saveUid(uid: String) {
        sharedPreferenceService.saveUid(uid)
    }

    override fun getUserName(): String {
        return sharedPreferenceService.getUserName()
    }

    override fun getPassword(): String {
        return sharedPreferenceService.getPassword()
    }

    override fun getUid(): String {
        return sharedPreferenceService.getUid()
    }
}