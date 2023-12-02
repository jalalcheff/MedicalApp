package com.example.medicalapp.ui.screen.loginScreen

interface ILogin {
    suspend fun signIn(email: String? = "", password: String? = ""): String
}