package com.example.medicalapp.domain

interface SharedPreferencesRepository {
    fun saveUsername(userName: String)
    fun savePassword(password: String)
}