package com.example.medicalapp.domain

import javax.inject.Inject

class DeletePatientUsecase @Inject constructor(private val clincPatientsRepository: ClincPatientsRepository) {
    suspend fun deletePatientUsecase(patientDocument: String, uid: String){
        clincPatientsRepository.deletePatient(patientDocument = patientDocument, uid = uid)
    }
}