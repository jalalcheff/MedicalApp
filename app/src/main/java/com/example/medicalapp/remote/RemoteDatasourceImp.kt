package com.example.medicalapp.remote

import android.util.Log
import com.example.medicalapp.remote.resource.clincResource.ClincDetails
import com.example.medicalapp.remote.resource.clincResource.PatientResource
import com.example.medicalapp.repository.RemoteDatasource
import com.example.medicalapp.ui.screen.loginScreen.ILogin
import com.example.medicalapplication.domain.NetworkException
import com.google.android.gms.common.api.Response
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import java.io.IOException

class RemoteDatasourceImp() : RemoteDatasource {
    override suspend fun signIn(email: String?, password: String?): String {
        val auth = Firebase.auth
        var type = ""
        auth.signInWithEmailAndPassword(email ?: "", password ?: "").addOnCompleteListener {
            if (it.isSuccessful)
                type = it.result.user?.uid ?: ""
            else
                type = it.exception?.message.toString()
        }.await()
        return type
    }

    override suspend fun getClincDetails(clincUid: String): ClincDetails {
        val db = Firebase.firestore
        db.collection("clinc").document(clincUid).collection("clincDetails").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val data = document.data
                    RemoteUils.doctorName = data[RemoteUils.DOCTOR_NAME_KEY].toString()
                    RemoteUils.fieldName = data[RemoteUils.FIELD_NAME_KEY].toString()
                    RemoteUils.clincStartTime = data[RemoteUils.CLINC_START_TIME_KEY].toString()
                    RemoteUils.clincEndTime = data[RemoteUils.CLINC_END_TIME_KEY].toString()
                    Log.i("jalalDoc", "my data is ${document.data}")
                }
            }.addOnFailureListener { exception ->
                Log.i("jalalDoc", "${exception.message}")
            }.await()
        return ClincDetails(
            RemoteUils.doctorName,
            RemoteUils.fieldName,
            RemoteUils.clincStartTime,
            RemoteUils.clincEndTime
        )
    }
    override suspend fun getPatientsInSepcificDate(
        uid: String,
        date: String,
    ): List<PatientResource> {
        val patients = mutableListOf<PatientResource>()
        val db = Firebase.firestore
        db.collection("clinc").document(uid).collection("paitentQuery").document("14 تشرين الثاني 2023").collection("patients").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val data = document.data
                    RemoteUils.patientName = data[RemoteUils.PAITENT_NAME_KEY].toString()
                    RemoteUils.query = data[RemoteUils.QUERY_KEY].toString().toInt()
                    RemoteUils.reservationDate = data[RemoteUils.RESERVATION_KEY].toString()
                    patients.add(PatientResource(
                        name = RemoteUils.patientName,
                        query = RemoteUils.query,
                        reservationDate = RemoteUils.reservationDate
                    ))
                    Log.i("jalalDoc", "my data is ${document.data}")
                }
            }.addOnFailureListener { exception ->
                Log.i("jalalDoc", "${exception.message}")
            }.await()
        return patients
    }

    private suspend fun <T> tryToExecute(func: suspend () -> Task<AuthResult>): String {
        val response = func()
        // Log.d("TAG", "tryToExecute: ${response.code()}")
        if (response.isSuccessful) {
            return response.result.user?.uid ?: throw NetworkException.NotFoundException
        } else {
            throw NetworkException.UnAuthorizedException
        }
    }
}