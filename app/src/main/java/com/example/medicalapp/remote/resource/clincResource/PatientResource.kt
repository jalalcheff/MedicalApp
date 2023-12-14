package com.example.medicalapp.remote.resource.clincResource

data class PatientResource (
    val name: String = "",
    val query: Int = Integer.MIN_VALUE,
    val reservationDate: String = ""
)