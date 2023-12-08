package com.example.medicalapp.domain

import com.example.medicalapp.remote.resource.clincResource.ClincDetails
import com.example.medicalapp.repository.ClincDetailsRepository
import javax.inject.Inject

class ClincDetailsUsecase @Inject constructor(private val clincDetailsRepository: ClincDetailsRepository) {
    suspend fun getClincDetails( clincUid: String): ClincDetails{
        return clincDetailsRepository.getClincDetails(clincUid)
    }
}