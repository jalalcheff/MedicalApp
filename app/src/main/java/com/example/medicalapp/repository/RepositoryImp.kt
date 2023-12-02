package com.example.medicalapp.repository

import com.example.medicalapp.domain.LoginRepository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val remoteDatasource: RemoteDatasource): LoginRepository {
    override suspend fun login(email: String, password: String): String {
        return remoteDatasource.signIn(email, password)
    }
}