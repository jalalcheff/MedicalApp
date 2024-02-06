package com.example.medicalapp.di

import android.content.Context
import android.content.SharedPreferences
import com.example.medicalapp.local.SharedPreferenceImp
import com.example.medicalapp.repository.SharedPreferenceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {
    @Provides
    @Singleton
    fun provideFoodSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)


    @Provides
    @Singleton
    fun provideSharedPrefService(sharedPreferenceImpl: SharedPreferenceImp): SharedPreferenceService {
        return sharedPreferenceImpl
    }
}
