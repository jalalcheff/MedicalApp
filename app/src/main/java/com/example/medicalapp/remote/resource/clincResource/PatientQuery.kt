package com.example.medicalapp.remote.resource.clincResource
import com.google.gson.annotations.SerializedName

data class PatientQuery(
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("role")
    val role: Int,
    @SerializedName("state")
    val state: Int,
    @SerializedName("operation")
    val operationDate: String,
    @SerializedName("regularCheckUp")
    val regularCheckUp: String,
)
