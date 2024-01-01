package com.example.medicalapp.domain

import com.example.medicalapp.domain.entity.PatientsEntity
import com.example.medicalapp.remote.resource.clincResource.PatientResource

fun PatientResource.toPatientEntity(): PatientsEntity{
    return PatientsEntity(
        name = name,
        age = age,
        reservationTime = reservationTime,
        reservationDate = reservationDate
    )
}

fun List<PatientResource>.toPatientEntity(): List<PatientsEntity>{
    return map { it.toPatientEntity() }
}