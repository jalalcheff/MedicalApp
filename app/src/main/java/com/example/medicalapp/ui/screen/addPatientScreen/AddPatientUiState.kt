package com.example.medicalapp.ui.screen.addPatientScreen

data class AddPatientUiState(
    var name: String = "",
    var age: Int = 0,
    val reservationDate: String = "",
    var reservationTime: String = "",
    val query: Int = Int.MAX_VALUE
)
