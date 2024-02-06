package com.example.medicalapp.domain

interface SharedPreferencesRepository {
    fun saveUsername(userName: String)
    fun savePassword(password: String)
    fun saveUid(uid: String)
    fun getUserName(): String
    fun getPassword(): String
    fun getUid(): String
}