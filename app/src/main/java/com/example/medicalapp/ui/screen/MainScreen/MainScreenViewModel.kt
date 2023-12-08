package com.example.medicalapp.ui.screen.MainScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicalapp.domain.ClincDetailsUsecase
import com.example.medicalapp.remote.RemoteDatasourceImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class MainScreenViewModel @Inject constructor(savedStateHandle: SavedStateHandle, private val clincDetailsUsecase: ClincDetailsUsecase): ViewModel() {
    private val uid = MainScreenArgs(savedStateHandle).name
    private val _mainScreenData = MutableStateFlow(MainScreenUiState())
    val mainScreenData = _mainScreenData.asStateFlow()
    init {
        Log.i("jalal", "the passed uid is $uid")
        viewModelScope.launch {
            fetchClincDetails(clincUid = uid.toString())
        }
    }
    suspend fun fetchClincDetails(clincUid: String){
        val clincDetails = clincDetailsUsecase.getClincDetails(clincUid)
        _mainScreenData.update {
            it.copy(
                doctorName = clincDetails.doctorName,
                docotorField = clincDetails.doctorField,
                clincStartTime = clincDetails.clincStartTime,
                clincEndTime = clincDetails.clincEndTime
            )
        }
        Log.i("jalalDoc", "doctor name is ${_mainScreenData.value.doctorName}")

    }
}