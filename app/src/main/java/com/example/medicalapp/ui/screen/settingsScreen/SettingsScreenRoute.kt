package com.example.medicalapp.ui.screen.settingsScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "SettingsScreen"

fun NavController.navigateToSettingsScreen(uid: String) {
    navigate("$ROUTE/$uid")
}

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.SettingsScreenRoute(navController: NavController) {
    composable(
        "$ROUTE/{uid}",
        arguments = listOf(navArgument("uid") { NavType.StringType })
    ) { SettingsScreen(navController) }

}

class SettingsScreenArgs(savedStateHandle: SavedStateHandle){
    val name = checkNotNull(savedStateHandle[ARGS_NAME])
    companion object{
        private const val ARGS_NAME = "uid"
    }
}

