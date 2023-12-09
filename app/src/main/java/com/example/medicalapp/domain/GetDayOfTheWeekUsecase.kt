package com.example.medicalapp.domain


class GetDayOfTheWeekUsecase {
    fun getDayOfTheWeek(dayOfWeek: Int): String {
        return when(dayOfWeek){
            0 -> "السبت"
            1 -> "الاحد"
            2 -> "الاثنين"
            3 -> "الثلاثاء"
            4 -> "الاربعاء"
            5 -> "الخميس"
            else -> "الجمعة"
        }
    }
}