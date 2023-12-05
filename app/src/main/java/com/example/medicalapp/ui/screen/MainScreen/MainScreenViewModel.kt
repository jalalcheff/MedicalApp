package com.example.medicalapp.ui.screen.MainScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class MainScreenViewModel @Inject constructor(savedStateHandle: SavedStateHandle): ViewModel() {
    private val uid = MainScreenArgs(savedStateHandle).name
    init {
        Log.i("jalal", "the passed uid is $uid")
    }
}