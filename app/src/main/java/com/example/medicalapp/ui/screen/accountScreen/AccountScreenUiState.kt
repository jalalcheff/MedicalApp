package com.example.medicalapp.ui.screen.accountScreen

data class AccountScreenUiState(
    val oldPassword: String = "",
    var newPassword: String = "",
    var oldEnteredPassword: String = "",
    var confirmedNewPassword: String = "",
    val uid: String = ""
)
