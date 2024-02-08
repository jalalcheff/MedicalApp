package com.example.medicalapp.ui.screen.accountScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicalapp.domain.ChangePasswordUsecase
import com.example.medicalapp.domain.GetPasswordUsecase
import com.example.medicalapp.domain.GetUidUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel

class AccountScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPasswordUsecase: GetPasswordUsecase,
    private val changePasswordUsecase: ChangePasswordUsecase,
    private val uidUsecase: GetUidUsecase
) : ViewModel() {
    private val _accountScreenData = MutableStateFlow(AccountScreenUiState())
    val accountScreenData = _accountScreenData.asStateFlow()

    init {
        viewModelScope.launch {
            fetchOldPasswordAndUid()
        }
    }

    private fun fetchOldPasswordAndUid() {
        val oldPassword = getPasswordUsecase.getPasswordUsecase()
        val uid = uidUsecase.getUidUsecase()
        _accountScreenData.update {
            it.copy(
                oldPassword = oldPassword,
                uid = uid
            )
        }
    }

    suspend fun changePassword(): Boolean {
        return if (_accountScreenData.value.oldEnteredPassword == _accountScreenData.value.oldPassword && _accountScreenData.value.newPassword == _accountScreenData.value.confirmedNewPassword){
            changePasswordUsecase.changePasswordUsecase(password = _accountScreenData.value.newPassword)
            true
        } else
            false
    }
}