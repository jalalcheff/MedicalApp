package com.example.medicalapp.repository

import com.example.medicalapp.remote.resource.clincResource.ClincDetails
import com.example.medicalapp.remote.resource.clincResource.PatientResource
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult


interface RemoteDatasource {
    suspend fun signIn(email: String? = "", password: String? = ""): String
    suspend fun getClincDetails(clincUid: String): ClincDetails
    suspend fun getPatientsInSepcificDate(uid: String, date: String): List<PatientResource>
    suspend fun addPatientInSpecificDate(uid: String, date: String, patientResource: PatientResource): Boolean
    suspend fun getNumberOfPatientsInSepcificDate(uid: String, date: String): Int
    suspend fun editAccountInformation(doctorName: String, fieldName: String, startExistenceTime: String, endExistenceTime: String, clincUid: String)
    suspend fun deletePatient(patientDocument: String, uid: String)

}