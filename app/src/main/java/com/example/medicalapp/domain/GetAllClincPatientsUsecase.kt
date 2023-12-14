package com.example.medicalapp.domain

import com.example.medicalapp.remote.resource.clincResource.PatientResource
import javax.inject.Inject

class GetAllClincPatientsUsecase @Inject constructor(private val clincPatientsRepository: ClincPatientsRepository) {
    suspend fun getAllPatients(uid: String, date: String): List<PatientResource>{
        return clincPatientsRepository.getPatientsRepository(uid, date)
    }
}