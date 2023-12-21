package com.example.medicalapp.ui.screen.addPatientScreen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "addPatientScreen"
fun NavGraphBuilder.AddPatient(navController: NavHostController){
    composable(
        "$ROUTE/{uid}",
        arguments = listOf(navArgument("uid"){ NavType.StringType })
        )
    { AddPatientScreen(navController)}
}
fun NavController.navigateToAddPatientScreen(uid: String){
    navigate("$ROUTE/$uid")
}

class AddPatientArgs(savedStateHandle: SavedStateHandle){
    val uid = checkNotNull(savedStateHandle[ARGS_NAME])
    companion object{
        const val ARGS_NAME = "uid"
    }
}

