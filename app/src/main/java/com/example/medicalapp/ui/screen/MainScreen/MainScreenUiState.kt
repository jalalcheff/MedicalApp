package com.example.medicalapp.ui.screen.MainScreen

import com.example.medicalapp.domain.entity.BookingDayEntity
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
    val patients: List<PatientResource> = emptyList(),
    var nextSevenDays: List<NextSevenDaysState> = mutableListOf(NextSevenDaysState())
)
{
    data class NextSevenDaysState(
    val dayName: String = "",
    val day: String = "",
    val month: String = "",
    val year: String = "",
    var isSelected: Boolean = false
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
