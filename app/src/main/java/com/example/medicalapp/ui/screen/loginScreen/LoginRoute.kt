package com.example.medicalapp.ui.screen.loginScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
private const val ROUTE = "LoginScreen"
@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.LoginRoute(navController: NavController){
    composable(ROUTE){ LoginScreen(navController = navController)}
}
fun NavController.navigateToLoginScreen(emptyBackStack: Boolean = false) {
    if (emptyBackStack) {
        navigate(ROUTE) {
            popUpTo(0)
        }
    } else
        navigate(ROUTE)
}