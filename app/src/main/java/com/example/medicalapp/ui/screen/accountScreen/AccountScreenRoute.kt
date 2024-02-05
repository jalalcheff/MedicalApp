package com.example.medicalapp.ui.screen.accountScreen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.medicalapp.ui.screen.doctorInformationScreen.DoctorInformationScreen

private const val ROUTE = "AccountScreen"

fun NavController.navigateToAccountScreen(uid: String) {
    navigate("$ROUTE/$uid")
}

fun NavGraphBuilder.AccountScreenScreenRoute(navController: NavController) {
    composable(
        "$ROUTE/{uid}",
        arguments = listOf(navArgument("uid") { NavType.StringType })
    ) { AccountScreen(navController) }

}

class AccountArgs(savedStateHandle: SavedStateHandle){
    val name = checkNotNull(savedStateHandle[ARGS_NAME])
    companion object{
        private const val ARGS_NAME = "uid"
    }
}

