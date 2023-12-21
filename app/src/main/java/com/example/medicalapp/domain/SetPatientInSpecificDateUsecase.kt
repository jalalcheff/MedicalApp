package com.example.medicalapp.domain

import com.example.medicalapp.remote.resource.clincResource.PatientResource
import javax.inject.Inject

class SetPatientInSpecificDateUsecase @Inject constructor(private val clincPatientsRepository: ClincPatientsRepository) {
    suspend fun setPatientInSpecificDate(uid: String, date: String, patient: PatientResource): Boolean{
        return clincPatientsRepository.setPatientRepository(uid = uid, date = date, patientResource = patient)
    }
}