package com.example.medicalapp.repository

import com.example.medicalapp.domain.ClincDetailsRepository
import com.example.medicalapp.remote.resource.clincResource.ClincDetails
import javax.inject.Inject

class ClincDetailsRepository @Inject constructor(private val remoteDatasource: RemoteDatasource): ClincDetailsRepository {
    override suspend fun getClincDetails(clincUid: String): ClincDetails {
        return remoteDatasource.getClincDetails(clincUid)
    }
}