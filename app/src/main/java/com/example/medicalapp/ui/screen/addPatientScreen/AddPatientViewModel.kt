package com.example.medicalapp.ui.screen.addPatientScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.medicalapp.domain.GetCurrentDateUsecase
import com.example.medicalapp.domain.SetPatientInSpecificDateUsecase
import com.example.medicalapp.remote.resource.clincResource.PatientResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel

class AddPatientViewModel @Inject constructor(
    private val setPatientInSpecificDateUsecase: SetPatientInSpecificDateUsecase,
    private val savedStateHandle: SavedStateHandle,
    private val getCurrentDateUsecase: GetCurrentDateUsecase
): ViewModel() {
    private val uid = AddPatientArgs(savedStateHandle).uid.toString()
    private val _AddPatientState = MutableStateFlow(AddPatientUiState())
    val addPatientState = _AddPatientState.asStateFlow()

    suspend fun addNewPatient(){
        val currentDate = getCurrentDateUsecase.getCurrentDate()
        val date: String =
            "${currentDate.month} ${currentDate.year} ${currentDate.monthName}"
        _AddPatientState.update {
            it.copy(
                name = _AddPatientState.value.name,
                age = _AddPatientState.value.age,
                reservationTime = _AddPatientState.value.reservationTime,
                reservationDate = _AddPatientState.value.reservationDate
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
}