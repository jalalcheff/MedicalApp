package com.example.medicalapp.domain

import java.util.Calendar

class GetCurrentDateUsecase {
    fun getCurrentDate(): CurrentDateInstance{
        val currentCalendar = Calendar.getInstance()
        return CurrentDateInstance(
            time = "${currentCalendar.get(Calendar.HOUR)} : ${currentCalendar.get(Calendar.MINUTE)}",
            day = GetDayOfTheWeekUsecase().getDayOfTheWeek(currentCalendar.get(Calendar.DAY_OF_WEEK)),
            month = "${currentCalendar.get(Calendar.DAY_OF_MONTH)}",
            monthName = GetCurrentMonth().getCurrentMonth(currentCalendar.get(Calendar.MONTH)),
            year = "${currentCalendar.get(Calendar.YEAR)}"
        )
    }
}