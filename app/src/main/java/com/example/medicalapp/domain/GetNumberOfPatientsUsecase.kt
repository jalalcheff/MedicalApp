package com.example.medicalapp.domain

import javax.inject.Inject

class GetNumberOfPatientsUsecase @Inject constructor(private val clincPatientsRepository: ClincPatientsRepository) {
    suspend fun getNumberOfPatients(uid: String, date: String): Int{
        return clincPatientsRepository.getNumberOfPatientsRepository(uid, date)
    }
}