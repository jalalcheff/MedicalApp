package com.example.medicalapp.domain


interface LoginRepository {
    suspend fun login(email: String, password: String): String
}