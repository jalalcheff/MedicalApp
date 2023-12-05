package com.example.medicalapp.ui.screen.loginScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
private const val ROUTE = "LoginScreen"
fun NavGraphBuilder.LoginRoute(navController: NavController){
    composable(ROUTE){ LoginScreen(navController = navController)}
}