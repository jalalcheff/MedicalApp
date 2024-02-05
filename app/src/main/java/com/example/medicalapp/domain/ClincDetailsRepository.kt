package com.example.medicalapp.domain

import com.example.medicalapp.remote.resource.clincResource.ClincDetails

interface ClincDetailsRepository {
    suspend fun getClincDetails(clincUid: String): ClincDetails
    suspend fun updateAccountInformation(doctorName: String, fieldName: String, startExistenceTime: String, endExistenceTime: String, clincUid: String)
}