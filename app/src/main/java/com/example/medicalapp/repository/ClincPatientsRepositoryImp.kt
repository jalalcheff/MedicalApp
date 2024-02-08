package com.example.medicalapp.repository

import com.example.medicalapp.domain.ClincPatientsRepository
import com.example.medicalapp.remote.resource.clincResource.PatientResource
import javax.inject.Inject

class ClincPatientsRepositoryImp @Inject constructor(private val remoteDatasource: RemoteDatasource): ClincPatientsRepository {
    override suspend fun getPatientsRepository(uid: String, date: String): List<PatientResource> {
        return remoteDatasource.getPatientsInSepcificDate(uid, date)
    }

    override suspend fun setPatientRepository(
        uid: String,
        date: String,
        patientResource: PatientResource,
    ): Boolean {
        return remoteDatasource.addPatientInSpecificDate(uid, date, patientResource)
    }

    override suspend fun getNumberOfPatientsRepository(uid: String, date: String): Int {
        return remoteDatasource.getNumberOfPatientsInSepcificDate(uid, date)
    }

    override suspend fun deletePatient(patientDocument: String, uid: String, name: String) {
        remoteDatasource.deletePatient(patientDocument = patientDocument, uid = uid, name = name)
    }
}