package com.example.medicalapp.ui.screen.MainScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicalapp.domain.ClincDetailsUsecase
import com.example.medicalapp.domain.CurrentDateInstance
import com.example.medicalapp.domain.GetAllClincPatientsUsecase
import com.example.medicalapp.domain.GetCurrentDateUsecase
import com.example.medicalapp.domain.GetCurrentMonth
import com.example.medicalapp.domain.GetCurrentSevenDays
import com.example.medicalapp.domain.SetPatientInSpecificDateUsecase
import com.example.medicalapp.remote.RemoteDatasourceImp
import com.example.medicalapp.remote.resource.clincResource.PatientResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel

class MainScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val clincDetailsUsecase: ClincDetailsUsecase,
    private val getCurrentDateUsecase: GetCurrentDateUsecase,
    private val getAllClincPatientsUsecase: GetAllClincPatientsUsecase,
    private val getCurrentSevenDays: GetCurrentSevenDays,
    private val getCurrentMonth: GetCurrentMonth
) : ViewModel() {
    private val uid = MainScreenArgs(savedStateHandle).name
    private val _mainScreenData = MutableStateFlow(MainScreenUiState())
    val mainScreenData = _mainScreenData.asStateFlow()

    init {
        Log.i("jalal", "the passed uid is $uid")
        Log.i("jalal", "seven days are : ${getCurrentSevenDays.getCurrentSevenDay()} and ${1 % 7}")
        viewModelScope.launch {
            fetchClincDetails(clincUid = uid.toString())
            fetchCurrentDate()
            fetchPatientsDetails()
            fetchNextSevenDays()
        }
    }

    private fun fetchNextSevenDays() {
        val nextSevenDays = getCurrentSevenDays.getCurrentSevenDay()
        _mainScreenData.update {
            it.copy(nextSevenDays = nextSevenDays.toNextSevenDaysState())
        }
        Log.i("stateNextSevenDays", "next seven days : ${_mainScreenData.value.nextSevenDays}")
    }


    suspend fun fetchPatientsDetails(
        date: String = "${_mainScreenData.value.dayOfTheMonth} ${_mainScreenData.value.year} ${_mainScreenData.value.monthName}",
    ) {
        val patients = getAllClincPatientsUsecase.getAllPatients(uid = uid.toString(), date = date)
        Log.i("myDate", "date before: $date")
        _mainScreenData.update {
            it.copy(patients = patients)
        }
    }

    private fun fetchCurrentDate() {
        val currentDate = getCurrentDateUsecase.getCurrentDate()
        _mainScreenData.update {
            it.copy(
                monthName = currentDate.monthName,
                dayName = currentDate.day,
                dayOfTheMonth = currentDate.month,
                year = currentDate.year
            )
        }
    }

    suspend fun fetchClincDetails(clincUid: String) {
        val clincDetails = clincDetailsUsecase.getClincDetails(clincUid)
        _mainScreenData.update {
            it.copy(
                doctorName = clincDetails.doctorName,
                docotorField = clincDetails.doctorField,
                clincStartTime = clincDetails.clincStartTime,
                clincEndTime = clincDetails.clincEndTime,
                uid = clincUid
            )
        }
        Log.i("jalalDoc", "doctor name is ${_mainScreenData.value.doctorName}")
    }

    suspend fun updateCardState(index: Int) {
        val currentMonth = getCurrentMonth.getCurrentMonth(_mainScreenData.value.nextSevenDays[index].month.toInt())
        val date: String =
            "${_mainScreenData.value.nextSevenDays[index].day} " +
                    "${_mainScreenData.value.nextSevenDays[index].year} " +
                   currentMonth
        val patients = getAllClincPatientsUsecase.getAllPatients(uid = uid.toString(), date = date)
        val selectedCard = getCurrentSevenDays.getCurrentSevenDay().toNextSevenDaysState()
        selectedCard[index].isSelected = true
        _mainScreenData.update {
            it.copy(nextSevenDays = selectedCard, patients = patients)
        }
        Log.i("myDate", "date before: $date")
    }
}