package com.example.medicalapp.di

import com.example.medicalapp.domain.ClincPatientsRepository
import com.example.medicalapp.domain.SharedPreferencesRepository
import com.example.medicalapp.repository.ClincDetailsRepository
import com.example.medicalapp.repository.ClincPatientsRepositoryImp
import com.example.medicalapp.repository.SharedPreferencesRepositoryImp
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
    @Binds
    @Singleton
    abstract fun provideClincDetailsRepository(clincDetailsRepository: ClincDetailsRepository): com.example.medicalapp.domain.ClincDetailsRepository
    @Binds
    @Singleton
    abstract fun provideSharedPreferncesRepository(sharedPreferencesRepositoryImp: SharedPreferencesRepositoryImp): SharedPreferencesRepository

}