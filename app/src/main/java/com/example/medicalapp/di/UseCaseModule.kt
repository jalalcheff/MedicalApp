package com.example.medicalapp.di

import com.example.medicalapp.domain.ClincDetailsRepository
import com.example.medicalapp.domain.ClincPatientsRepository
import com.example.medicalapp.domain.ConvertTextIntoRtlUsecase
import com.example.medicalapp.domain.GetAllClincPatientsUsecase
import com.example.medicalapp.domain.GetCurrentDateUsecase
import com.example.medicalapp.domain.GetCurrentMonth
import com.example.medicalapp.domain.GetDayOfTheWeekUsecase
import com.example.medicalapp.domain.GetNextSevenDaysUsecase
import com.example.medicalapp.domain.UpdateClincDetailsUsecase
import com.example.medicalapp.repository.ClincPatientsRepositoryImp
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
    @Provides
    @Singleton
    fun provideNextSevenDaysUsecase(): GetNextSevenDaysUsecase = GetNextSevenDaysUsecase(GetDayOfTheWeekUsecase())
    @Provides
    @Singleton
    fun provideGetDayOfWeekUsecase(): GetDayOfTheWeekUsecase = GetDayOfTheWeekUsecase()
    @Provides
    @Singleton
    fun provideGetCurrentMonthUsecase(): GetCurrentMonth = GetCurrentMonth()
    @Provides
    @Singleton
    fun provideUpdateInformationAccountUsecase(clincDetailsRepository: ClincDetailsRepository): UpdateClincDetailsUsecase = UpdateClincDetailsUsecase(clincDetailsRepository)
    @Provides
    @Singleton
    fun provideConvertTextIntoRtlUsecase(): ConvertTextIntoRtlUsecase = ConvertTextIntoRtlUsecase()


}