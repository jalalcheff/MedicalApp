package com.example.medicalapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medicalapp.ui.screen.MainScreen.MainScreenRoute
import com.example.medicalapp.ui.screen.loginScreen.LoginRoute
import com.example.medicalapp.ui.screen.loginScreen.LoginScreen

@Composable
fun MedicalNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "LoginScreen") {
        LoginRoute(navController = navHostController)
        MainScreenRoute(navController = navHostController)
    }
}