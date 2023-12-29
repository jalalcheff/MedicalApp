package com.example.medicalapp.ui.screen.addPatientScreen

import com.example.medicalapp.domain.entity.BookingDayEntity
import com.example.medicalapp.ui.screen.MainScreen.MainScreenUiState

data class AddPatientUiState(
    var name: String = "",
    var age: Int = 0,
    val reservationDate: String = "",
    var reservationTime: String = "",
    val query: Int = Int.MAX_VALUE,
    var nextSevenDays: List<NextSevenDaysState> = mutableListOf(NextSevenDaysState()),
    var selectedIndex: Int = 0
) {
    data class NextSevenDaysState(
        val dayName: String = "",
        val day: String = "",
        val month: String = "",
        val year: String = "",
        var isSelected: Boolean = false,
    )
}
fun BookingDayEntity.toNextSevenDaysState(): AddPatientUiState.NextSevenDaysState{
    return AddPatientUiState.NextSevenDaysState(
        dayName = dayName,
        day = day,
        month = month,
        year = year,
        isSelected = false
    )
}
fun List<BookingDayEntity>.toNextSevenDaysState(): List<AddPatientUiState.NextSevenDaysState>{
    return this.map { it.toNextSevenDaysState() }
}
