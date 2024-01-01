package com.example.medicalapp.ui.screen.addPatientScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.medicalapp.domain.GetCurrentDateUsecase
import com.example.medicalapp.domain.GetCurrentMonth
import com.example.medicalapp.domain.GetCurrentSevenDays
import com.example.medicalapp.domain.SetPatientInSpecificDateUsecase
import com.example.medicalapp.remote.resource.clincResource.PatientResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel

class AddPatientViewModel @Inject constructor(
    private val setPatientInSpecificDateUsecase: SetPatientInSpecificDateUsecase,
    private val savedStateHandle: SavedStateHandle,
    private val getCurrentDateUsecase: GetCurrentDateUsecase,
    private val getCurrentSevenDays: GetCurrentSevenDays,
    private val getCurrentMonth: GetCurrentMonth
): ViewModel() {
    private val uid = AddPatientArgs(savedStateHandle).uid.toString()
    private val _AddPatientState = MutableStateFlow(AddPatientUiState())
    val addPatientState = _AddPatientState.asStateFlow()
    init {
        fetchSevenDays()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun fetchSevenDays() {
        val nextSevenDays = getCurrentSevenDays.getCurrentSevenDay()
        _AddPatientState.update {
            it.copy(nextSevenDays = nextSevenDays.toNextSevenDaysState())
        }
    }

    suspend fun addNewPatient(){
        val index = _AddPatientState.value.selectedIndex
        val nextSevenDays = _AddPatientState.value.nextSevenDays
        val currentMonth = getCurrentMonth.getCurrentMonth(nextSevenDays[index].month.toInt())
        val date: String =
            "${nextSevenDays[index].day} " +
                    "${nextSevenDays[index].year} " +
                    currentMonth
        _AddPatientState.update {
            it.copy(
                name = _AddPatientState.value.name,
                age = _AddPatientState.value.age,
                reservationTime = _AddPatientState.value.reservationTime,
                reservationDate = date,
                uid = uid
            )
        }
        setPatientInSpecificDateUsecase.setPatientInSpecificDate(
            uid = uid,
            date = date,
            patient = PatientResource(
                name = _AddPatientState.value.name,
                reservationDate = _AddPatientState.value.reservationDate,
                reservationTime = _AddPatientState.value.reservationTime,
                age = _AddPatientState.value.age,
                query = _AddPatientState.value.query
            )
        )
    }

    fun updateSelectedDate(index: Int){
        val selectedCard = getCurrentSevenDays.getCurrentSevenDay().toNextSevenDaysState()
        selectedCard[index].isSelected = true
        _AddPatientState.update {
            it.copy(nextSevenDays = selectedCard, selectedIndex = index)
        }
    }
}