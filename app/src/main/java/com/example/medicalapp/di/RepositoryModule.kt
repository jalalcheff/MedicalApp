package com.example.medicalapp.di

import com.example.medicalapp.domain.ClincPatientsRepository
import com.example.medicalapp.repository.ClincPatientsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideClincPatientsRepository(clincPatientsRepository: ClincPatientsRepositoryImp): ClincPatientsRepository
}