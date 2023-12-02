package com.example.medicalapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.medicalapp.remote.RemoteDatasourceImp
import com.example.medicalapp.ui.screen.loginScreen.LoginScreen
import com.example.medicalapp.ui.screen.loginScreen.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodApp(){
        val navGraph = rememberNavController()
        MedicalNavGraph(navGraph)
}