package com.example.medicalapp.domain

import javax.inject.Inject

class UpdateClincDetailsUsecase @Inject constructor(val clincDetailsRepository: ClincDetailsRepository) {
    suspend fun updateClincDetailsUsecase(
        doctorName: String,
        fieldName: String,
        startExistenceTime: String,
        endExistenceTime: String,
        clincUid: String,
    ) {
        clincDetailsRepository.updateAccountInformation(
            doctorName = doctorName,
            fieldName = fieldName,
            startExistenceTime = startExistenceTime,
            endExistenceTime = endExistenceTime,
            clincUid = clincUid
        )
    }
}