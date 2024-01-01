package com.example.medicalapp.ui.screen.MainScreen

import com.example.medicalapp.domain.entity.BookingDayEntity
import com.example.medicalapp.domain.entity.PatientsEntity
import com.example.medicalapp.remote.resource.clincResource.PatientResource

data class MainScreenUiState(
    val uid: String = "",
    val doctorName: String = "",
    val docotorField: String = "",
    val clincStartTime: String = "",
    val clincEndTime: String = "",
    val dayOfTheMonth: String = "",
    val dayName: String = "",
    val monthName: String = "",
    val year: String = "",
    val patients: List<PatientsState> = emptyList(),
    var nextSevenDays: List<NextSevenDaysState> = mutableListOf(NextSevenDaysState()),
    var isLoading: Boolean = true
)
{
    data class NextSevenDaysState(
    val dayName: String = "",
    val day: String = "",
    val month: String = "",
    val year: String = "",
    var isSelected: Boolean = false
    )

    data class PatientsState(
        val name: String = "",
        val reservationDate: String = "",
        val age: Int = 0,
        val reservationTime: String = "",
        val query: Int = Int.MAX_VALUE
    )
}

fun BookingDayEntity.toNextSevenDaysState(): MainScreenUiState.NextSevenDaysState{
    return MainScreenUiState.NextSevenDaysState(
        dayName = dayName,
        day = day,
        month = month,
        year = year,
        isSelected = false
    )
}
fun List<BookingDayEntity>.toNextSevenDaysState(): List<MainScreenUiState.NextSevenDaysState>{
    return this.map { it.toNextSevenDaysState() }
}
fun PatientResource.toPatientState(query: Int): MainScreenUiState.PatientsState {
    return MainScreenUiState.PatientsState(
        name = name,
        age = age,
        reservationTime = reservationTime,
        reservationDate = reservationDate,
        query = query
    )
}

fun List<PatientResource>.toPatientState(): List<MainScreenUiState.PatientsState>{
    var count = 0
    return map {
        count++
        it.toPatientState(count)
    }
}
