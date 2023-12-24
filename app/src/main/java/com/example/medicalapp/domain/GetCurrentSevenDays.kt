package com.example.medicalapp.domain

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.medicalapp.domain.entity.BookingDayEntity
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class GetCurrentSevenDays @Inject constructor(
    private val getNextSevenDaysUsecase: GetNextSevenDaysUsecase
    ) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentSevenDay(): List<BookingDayEntity>{
        val days = mutableListOf<String>()
        val currentDate: LocalDate = LocalDate.now()
        for (i in 0 until 7) {
            val futureDate = currentDate.plusDays(i.toLong())
            val formattedDate = futureDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            days.add(formattedDate)
            Log.i("sevenDays", "${i + 1} : $formattedDate")
        }
        val sevenDays =getNextSevenDaysUsecase.convertToNextSevenDays(days)
        Log.i("myDays", sevenDays.toString())
        return sevenDays
    }
}