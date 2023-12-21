package com.example.medicalapp.ui.screen.MainScreen

import com.example.medicalapp.remote.resource.clincResource.PatientResource

data class MainScreenUiState(
    val uid: String = "",
    val doctorName: String = "" ,
    val docotorField: String = "",
    val clincStartTime: String = "",
    val clincEndTime: String = "",
    val dayOfTheMonth: String = "",
    val dayName: String = "",
    val monthName: String = "",
    val year: String = "",
    val patients: List<PatientResource> = emptyList()
)/*{
    data class Patients(
        val name: String = "",
        val query: Int = 0,
        val reservationDate: String = ""
    )
}
*/