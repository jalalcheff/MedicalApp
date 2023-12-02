package com.example.medicalapp.di

import com.example.medicalapp.domain.LoginRepository
import com.example.medicalapp.remote.RemoteDatasourceImp
import com.example.medicalapp.repository.RemoteDatasource
import com.example.medicalapp.repository.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class RemoteModule {

        @Binds
        @Singleton
        abstract fun bindLoginData(repositoryImp: RepositoryImp): LoginRepository
        @Binds
        @Singleton
        abstract fun bindRemoteDatasource(remoteDatasourceImp: RemoteDatasourceImp): RemoteDatasource
    }