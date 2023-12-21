package com.example.medicalapp.remote

import android.icu.number.IntegerWidth

object RemoteUils  {
    var doctorName: String = ""
    var fieldName : String = ""
    var clincStartTime: String = ""
    var clincEndTime: String = ""
    var patientName: String = ""
    var query: Int = Int.MIN_VALUE
    var reservationDate: String = ""
    const val DOCTOR_NAME_KEY ="doctorName"
    const val FIELD_NAME_KEY ="fieldName"
    const val CLINC_START_TIME_KEY ="clincStartTime"
    const val CLINC_END_TIME_KEY ="clincEndTime"
    const val PAITENT_NAME_KEY ="name"
    const val QUERY_KEY ="query"
    const val RESERVATION_KEY ="reservationDate"
    const val AGE_KEY ="age"
    const val RESERVATION_TIME_KEY ="reservationTime"

}