package com.example.medicalapp.di

import com.example.medicalapp.domain.GetCurrentDateUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
            @Provides
            @Singleton
            fun provideCurrentDateUsecase(): GetCurrentDateUsecase = GetCurrentDateUsecase()

}