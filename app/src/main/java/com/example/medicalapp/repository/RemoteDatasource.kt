package com.example.medicalapp.repository


interface RemoteDatasource {
    suspend fun signIn(email: String? = "", password: String? = ""): String
}