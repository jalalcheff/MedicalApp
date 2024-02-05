package com.example.medicalapp.ui.screen.doctorInformationScreen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "DoctorInformationScreen"

fun NavController.navigateToDoctorInformationScreen(uid: String) {
    navigate("$ROUTE/$uid")
}

fun NavGraphBuilder.DocotrInformationScreenRoute(navController: NavController) {
    composable(
        "$ROUTE/{uid}",
        arguments = listOf(navArgument("uid") { NavType.StringType })
    ) { DoctorInformationScreen(navController) }

}

class DoctorInformationArgs(savedStateHandle: SavedStateHandle) {
    val name = checkNotNull(savedStateHandle[ARGS_NAME])

    companion object {
        private const val ARGS_NAME = "uid"
    }
}

