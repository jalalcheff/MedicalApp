package com.example.medicalapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.medicalapp.FoodApp
import com.example.medicalapp.remote.RemoteDatasourceImp
import com.example.medicalapp.ui.screen.loginScreen.LoginScreen
import com.example.medicalapp.ui.screen.loginScreen.LoginViewModel
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        setContent {
            FoodApp()
           /* LaunchedEffect(true){
                RemoteDatasourceImp().signIn("test@gmail.com", "12345678")
            }*/
        }
    }
}