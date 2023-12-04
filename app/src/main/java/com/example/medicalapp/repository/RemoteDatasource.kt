package com.example.medicalapp.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult


interface RemoteDatasource {
    suspend fun signIn(email: String? = "", password: String? = ""): String
}