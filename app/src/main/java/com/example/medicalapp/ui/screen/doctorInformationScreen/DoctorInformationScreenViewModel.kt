package com.example.medicalapp.ui.screen.doctorInformationScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicalapp.domain.ClincDetailsUsecase
import com.example.medicalapp.domain.GetAllClincPatientsUsecase
import com.example.medicalapp.domain.GetCurrentDateUsecase
import com.example.medicalapp.domain.GetCurrentMonth
import com.example.medicalapp.domain.GetCurrentSevenDays
import com.example.medicalapp.domain.GetNumberOfPatientsUsecase
import com.example.medicalapp.domain.UpdateClincDetailsUsecase
import com.example.medicalapp.ui.screen.MainScreen.MainScreenUiState
import com.example.medicalapp.ui.screen.MainScreen.toNextSevenDaysState
import com.example.medicalapp.ui.screen.MainScreen.toPatientState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel

class DoctorInformationScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val clincDetailsUsecase: ClincDetailsUsecase,
    private val getCurrentSevenDays: GetCurrentSevenDays,
    private val updateClincDetailsUsecase: UpdateClincDetailsUsecase,
) : ViewModel() {
    private val uid = DoctorInformationArgs(savedStateHandle).name
    private val _informationScreenData = MutableStateFlow(DoctorInformationUiState())
    val informationScreenData = _informationScreenData.asStateFlow()

    init {
        Log.i("jalal", "the passed uid is $uid")
        Log.i("jalal", "seven days are : ${getCurrentSevenDays.getCurrentSevenDay()} and ${1 % 7}")
        viewModelScope.launch {
            fetchClincDetails(clincUid = uid.toString())
        }
    }

    suspend fun fetchClincDetails(clincUid: String) {
        val clincDetails = clincDetailsUsecase.getClincDetails(clincUid)
        _informationScreenData.update {
            it.copy(
                doctorName = clincDetails.doctorName,
                doctorField = clincDetails.doctorField,
                doctorStartTime = clincDetails.clincStartTime,
                doctorEndTime = clincDetails.clincEndTime,
                clincUid = clincUid,
                isLoading = false
            )
        }
        Log.i("jalalDoc", "doctor name is ${_informationScreenData.value.doctorName}")
    }

    suspend fun updateAccountInformation(
        doctorName: String,
        fieldName: String,
        startExistenceTime: String,
        endExistenceTime: String,
        clincUid: String,
    ) {
        updateClincDetailsUsecase.updateClincDetailsUsecase(
            doctorName = doctorName,
            fieldName = fieldName,
            startExistenceTime = startExistenceTime,
            endExistenceTime = endExistenceTime,
            clincUid = clincUid
        )
    }
}