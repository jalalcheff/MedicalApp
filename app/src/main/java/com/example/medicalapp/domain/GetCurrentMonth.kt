package com.example.medicalapp.domain

class GetCurrentMonth {
    fun getCurrentMonth(dayOfTheMonth: Int): String{
        return when(dayOfTheMonth){
            1 -> "كانون الثاني"
            2 -> "شباط"
            3 -> "اذار"
            4 -> "نيسان"
            5 -> "ايار"
            6 -> "حزيران"
            7 -> "تموز"
            8 -> "اب"
            9 -> "ايلول"
            10 -> "تشرين الاول"
            11 -> "تشرين الثاني"
            else -> "كانون الاول"

        }
    }
}