package com.example.medicalapp.repository

interface SharedPreferenceService {
    fun saveUserName(userName: String)
    fun savePassword(password: String)
}