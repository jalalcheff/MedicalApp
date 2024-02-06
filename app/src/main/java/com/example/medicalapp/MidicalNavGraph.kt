package com.example.medicalapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.medicalapp.ui.screen.MainScreen.MainScreenRoute
import com.example.medicalapp.ui.screen.accountScreen.AccountScreenScreenRoute
import com.example.medicalapp.ui.screen.addPatientScreen.AddPatient
import com.example.medicalapp.ui.screen.doctorInformationScreen.DocotrInformationScreenRoute
import com.example.medicalapp.ui.screen.loginScreen.LoginRoute
import com.example.medicalapp.ui.screen.loginScreen.LoginScreen
import com.example.medicalapp.ui.screen.settingsScreen.SettingsScreenRoute

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MedicalNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "LoginScreen") {
        navigation(startDestination = "MainScreen", route = "graphOne"){
            MainScreenRoute(navController = navHostController)
            AddPatient(navController = navHostController)
            SettingsScreenRoute(navController = navHostController)
            AccountScreenScreenRoute(navController = navHostController)
            DocotrInformationScreenRoute(navController = navHostController)
        }
        LoginRoute(navController = navHostController)
    }
}