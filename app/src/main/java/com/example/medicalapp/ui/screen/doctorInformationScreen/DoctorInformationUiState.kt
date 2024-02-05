package com.example.medicalapp.ui.screen.doctorInformationScreen

data class DoctorInformationUiState(
    var doctorName: String = "",
    val doctorField: String = "",
    val doctorStartTime: String = "",
    val doctorEndTime: String = "",
    val doctorExistenceDate: String = "",
    val clincUid: String = "",
    val doctorProfileImage: String = "",
    val isLoading: Boolean = true
    )
