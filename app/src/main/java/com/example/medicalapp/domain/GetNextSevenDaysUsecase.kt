package com.example.medicalapp.domain

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.medicalapp.domain.entity.BookingDayEntity
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import javax.inject.Inject

class GetNextSevenDaysUsecase @Inject constructor(private val getDayOfTheWeekUsecase: GetDayOfTheWeekUsecase) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun convertToNextSevenDays(nextSevenDays: List<String>): List<BookingDayEntity>{
        val myBookingDay = mutableListOf<BookingDayEntity>()
        val calendar = Calendar.getInstance()
        var counter = 0
        for (i in nextSevenDays.indices){
            val days = nextSevenDays[i].split("-")
            myBookingDay.add(
                BookingDayEntity(
                    year = days[0],
                    month = days[1],
                    day = days[2],
                    dayName = getDayOfTheWeekUsecase.getDayOfTheWeek(calendar.get(Calendar.DAY_OF_WEEK)+counter)
                )
            )
            counter ++
        }
        return myBookingDay
    }

}