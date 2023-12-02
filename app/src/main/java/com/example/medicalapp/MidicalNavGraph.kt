package com.example.medicalapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medicalapp.ui.screen.loginScreen.LoginScreen

@Composable
fun MedicalNavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "LoginScreen"){
        composable("LoginScreen"){ LoginScreen()}
    }
}