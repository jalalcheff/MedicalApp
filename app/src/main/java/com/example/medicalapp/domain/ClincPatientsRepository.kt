package com.example.medicalapp.domain

import com.example.medicalapp.remote.resource.clincResource.PatientResource

interface ClincPatientsRepository {
    suspend fun getPatientsRepository(uid: String, date: String): List<PatientResource>
}