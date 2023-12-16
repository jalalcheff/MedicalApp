package com.example.medicalapp.ui.screen.MainScreen

data class MainScreenUiState(
    val doctorName: String = "" ,
    val docotorField: String = "",
    val clincStartTime: String = "",
    val clincEndTime: String = "",
    val dayOfTheMonth: String = "",
    val dayName: String = "",
    val monthName: String = "",
    val year: String = ""
)
