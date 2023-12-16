package com.example.medicalapp.repository

import com.example.medicalapp.domain.ClincPatientsRepository
import com.example.medicalapp.remote.resource.clincResource.PatientResource
import javax.inject.Inject

class ClincPatientsRepositoryImp @Inject constructor(private val remoteDatasource: RemoteDatasource): ClincPatientsRepository {
    override suspend fun getPatientsRepository(uid: String, date: String): List<PatientResource> {
        return remoteDatasource.getPatientsInSepcificDate(uid, date)
    }
}