package com.example.medicalapp.ui.screen.MainScreen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.medicalapp.ui.screen.MainScreen

private const val ROUTE = "MainScreen"

fun NavController.navigateToMainScreen(uid: String) {
    navigate("$ROUTE/$uid")
}

fun NavGraphBuilder.MainScreenRoute(navController: NavController) {
    composable(
        "$ROUTE/{uid}",
        arguments = listOf(navArgument("uid") { NavType.StringType })
    ) { MainScreen() }

}

class MainScreenArgs(savedStateHandle: SavedStateHandle){
    val name = checkNotNull(savedStateHandle[ARGS_NAME])
    companion object{
        private const val ARGS_NAME = "uid"
    }
}

