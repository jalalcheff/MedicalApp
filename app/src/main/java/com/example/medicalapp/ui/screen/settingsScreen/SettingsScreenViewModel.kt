package com.example.medicalapp.ui.screen.settingsScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicalapp.domain.ClearAuthenticatedDataUsecase
import com.example.medicalapp.domain.ClincDetailsUsecase
import com.example.medicalapp.domain.CurrentDateInstance
import com.example.medicalapp.domain.GetAllClincPatientsUsecase
import com.example.medicalapp.domain.GetCurrentDateUsecase
import com.example.medicalapp.domain.GetCurrentMonth
import com.example.medicalapp.domain.GetCurrentSevenDays
import com.example.medicalapp.domain.GetNumberOfPatientsUsecase
import com.example.medicalapp.domain.SetPatientInSpecificDateUsecase
import com.example.medicalapp.domain.SharedPreferencesRepository
import com.example.medicalapp.remote.RemoteDatasourceImp
import com.example.medicalapp.remote.resource.clincResource.PatientResource
import com.example.medicalapp.repository.SharedPreferenceService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel

class SettingsScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val clincDetailsUsecase: ClincDetailsUsecase,
    private val getCurrentDateUsecase: GetCurrentDateUsecase,
    private val getAllClincPatientsUsecase: GetAllClincPatientsUsecase,
    private val getCurrentSevenDays: GetCurrentSevenDays,
    private val getCurrentMonth: GetCurrentMonth,
    private val getNumberOfPatientsUsecase: GetNumberOfPatientsUsecase,
    private val clearAuthenticatedDataUsecase: ClearAuthenticatedDataUsecase,

) : ViewModel() {
    private val uid = SettingsScreenArgs(savedStateHandle).name

    init {
        Log.i("jalal", "the passed uid is $uid")
        Log.i("jalal", "seven days are : ${getCurrentSevenDays.getCurrentSevenDay()} and ${1 % 7}")
        viewModelScope.launch {
        }
    }
    fun getUid(): String{
        return uid.toString()
    }
    fun clearAuthenticatedData(){
        clearAuthenticatedDataUsecase.clearAuthenticatedDataUsecase()
    }
}