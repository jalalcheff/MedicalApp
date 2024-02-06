package com.example.medicalapp.repository

interface SharedPreferenceService {
    fun saveUserName(userName: String)
    fun savePassword(password: String)
    fun saveUid(uid: String)

    fun getUserName(): String
    fun getPassword(): String
    fun getUid(): String


}