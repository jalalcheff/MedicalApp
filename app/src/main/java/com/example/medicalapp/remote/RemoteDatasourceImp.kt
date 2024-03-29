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
                type = it.result.user?.uid ?: throw Exception("invalid info")
        }.await()
        return type
    }

    override suspend fun getClincDetails(clincUid: String): ClincDetails {
        val db = Firebase.firestore
        val clincDetails = ClincDetails()
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
        db.collection("clinc").document(uid).collection("patientQuery").document(date)
            .collection("patients").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val data = document.data
                    patients.add(
                        PatientResource(
                            name = data[RemoteUils.PAITENT_NAME_KEY].toString(),
                            query = data[RemoteUils.QUERY_KEY].toString().toInt(),
                            reservationDate = data[RemoteUils.RESERVATION_KEY].toString(),
                            age = data[RemoteUils.AGE_KEY].toString().toInt(),
                            reservationTime = data[RemoteUils.RESERVATION_TIME_KEY].toString()
                        )
                    )
                    Log.i("jalalPati", "my data is ${document.data}")
                }
            }.addOnFailureListener { exception ->
                Log.i("jalalDoc", "${exception.message}")
            }.await()
        return patients
    }

    override suspend fun addPatientInSpecificDate(
        uid: String,
        date: String,
        patientResource: PatientResource,
    ): Boolean {
        val db = Firebase.firestore
        val patient = hashMapOf(
            RemoteUils.PAITENT_NAME_KEY to patientResource.name,
            RemoteUils.QUERY_KEY to patientResource.query,
            RemoteUils.RESERVATION_KEY to patientResource.reservationDate,
            RemoteUils.AGE_KEY to patientResource.age,
            RemoteUils.RESERVATION_TIME_KEY to patientResource.reservationTime
        )
        var isPatientAdded = false
        db.collection("clinc")
            .document(uid)
            .collection("patientQuery")
            .document(date)
            .collection("patients")
            .document(patientResource.name)
            .set(patient)
            .addOnSuccessListener {
                Log.d("jalal", "DocumentSnapshot successfully written!")
                isPatientAdded = true
            }
            .addOnFailureListener { e ->
                Log.w("jalal", "Error writing document", e)
                isPatientAdded = false
            }.await()
        return isPatientAdded
    }

    override suspend fun getNumberOfPatientsInSepcificDate(uid: String, date: String): Int {
        val patients = mutableListOf<PatientResource>()
        val db = Firebase.firestore
        db.collection("clinc").document(uid).collection("patientQuery").document(date)
            .collection("patients").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val data = document.data
                    patients.add(
                        PatientResource(
                            name = data[RemoteUils.PAITENT_NAME_KEY].toString(),
                            query = data[RemoteUils.QUERY_KEY].toString().toInt(),
                            reservationDate = data[RemoteUils.RESERVATION_KEY].toString(),
                            age = data[RemoteUils.AGE_KEY].toString().toInt(),
                            reservationTime = data[RemoteUils.RESERVATION_TIME_KEY].toString()
                        )
                    )
                    Log.i("jalalPati", "my data is ${document.data}")
                }
            }.addOnFailureListener { exception ->
                Log.i("jalalDoc", "${exception.message}")
            }.await()
        return patients.size
    }

    override suspend fun editAccountInformation(
        doctorName: String,
        fieldName: String,
        startExistenceTime: String,
        endExistenceTime: String,
        clincUid: String,
    ) {
        val editedAccountInformation = mapOf(
            DOCTOR_NAME to doctorName,
            DOCTOR_FIELD to fieldName,
            CLINC_START_TIME to startExistenceTime,
            CLINC_END_TIME to endExistenceTime
        )
        val db = Firebase.firestore
        db.collection("clinc").document(clincUid)
            .collection("clincDetails").document("details")
            .set(editedAccountInformation).addOnSuccessListener {
                Log.d("jalal", "DocumentSnapshot successfully written!")
            }
            .addOnFailureListener { e ->
                throw Exception(e.message)
            }.await()
    }

    override suspend fun deletePatient(patientDocument: String, uid: String, name: String) {
        val db = Firebase.firestore
        db.collection("clinc").document(uid)
            .collection("patientQuery").document(patientDocument).collection("patients").document(name)
            .delete()
            .addOnFailureListener { throw NetworkException.NotFoundException }.addOnSuccessListener {
                Log.i("successDelete", "variable $it : ${patientDocument} : $uid: name : $name")
            }.await()
    }

    override suspend fun changePassword(newPassword: String) {
        FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)?.await()
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

    companion object {
        const val DOCTOR_NAME = "doctorName"
        const val DOCTOR_FIELD = "fieldName"
        const val CLINC_START_TIME = "clincStartTime"
        const val CLINC_END_TIME = "clincEndTime"
    }
}