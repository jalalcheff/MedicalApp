package com.example.medicalapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medicalapp.ui.screen.MainScreen.MainScreenRoute
import com.example.medicalapp.ui.screen.accountScreen.AccountScreenScreenRoute
import com.example.medicalapp.ui.screen.addPatientScreen.AddPatient
import com.example.medicalapp.ui.screen.doctorInformationScreen.DocotrInformationScreenRoute
import com.example.medicalapp.ui.screen.loginScreen.LoginRoute
import com.example.medicalapp.ui.screen.loginScreen.LoginScreen
import com.example.medicalapp.ui.screen.settingsScreen.SettingsScreenRoute

@Composable
fun MedicalNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "LoginScreen") {
        LoginRoute(navController = navHostController)
        MainScreenRoute(navController = navHostController)
        AddPatient(navController = navHostController)
        SettingsScreenRoute(navController = navHostController)
        AccountScreenScreenRoute(navController = navHostController)
        DocotrInformationScreenRoute(navController = navHostController)
    }
}