package com.example.medicalapp.remote

import android.util.Log
import com.example.medicalapp.repository.RemoteDatasource
import com.example.medicalapp.ui.screen.loginScreen.ILogin
import com.example.medicalapplication.domain.NetworkException
import com.google.android.gms.common.api.Response
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.io.IOException

class RemoteDatasourceImp() : RemoteDatasource {
    override suspend fun signIn(email: String?, password: String?): String{
        val auth = Firebase.auth
        var type = ""
        auth.signInWithEmailAndPassword(email ?: "", password ?: "").addOnCompleteListener {
            if (it.isSuccessful) {
                Log.i("jalalcheff"," ${FirebaseAuth.getInstance().currentUser?.email} his uid is : $type")
                type = it.result.user?.uid.toString()
            }
            else
            {
                Log.i("jalalcheff", "** ${it.exception?.message.toString()} ** uid is : $type")
                type = it.exception?.message.toString()
            }
        }
        return "2NT3XYpwYpYWdRrv6mwzzv88vqf2"
    }
    private suspend fun <T> tryToExecute(func: suspend () -> Task<AuthResult>): String {
        val response = func()
       // Log.d("TAG", "tryToExecute: ${response.code()}")
        if (response.isSuccessful) {
            return response.result.user?.uid ?: throw NetworkException.NotFoundException
        }
         else {
        throw  NetworkException.UnAuthorizedException
        }
    }
}