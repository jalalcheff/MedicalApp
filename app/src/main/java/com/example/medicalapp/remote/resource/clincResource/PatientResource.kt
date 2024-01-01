package com.example.medicalapp.remote.resource.clincResource

data class PatientResource (
    val name: String = "",
    val reservationDate: String = "",
    val age: Int = 0,
    val reservationTime: String = "",
    val query: Int = Int.MAX_VALUE
)