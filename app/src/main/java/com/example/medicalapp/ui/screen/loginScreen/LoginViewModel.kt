package com.example.medicalapp.ui.screen.loginScreen

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.medicalapp.domain.GetAuthenticatedStatusUsecase
import com.example.medicalapp.domain.GetCurrentSevenDays
import com.example.medicalapp.domain.GetPasswordUsecase
import com.example.medicalapp.domain.GetUidUsecase
import com.example.medicalapp.domain.GetUsernameUsecase
import com.example.medicalapp.domain.LoginUsecase
import com.example.medicalapp.domain.SavePasswordUsecase
import com.example.medicalapp.domain.SaveUidUsecase
import com.example.medicalapp.domain.SaveUsernameUsecase
import com.example.medicalapp.domain.SetAuthenticatedStatusUsecase
import com.example.medicalapp.ui.screen.MainScreen.navigateToMainScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel

class LoginViewModel @Inject constructor(
    private val loginUsecase: LoginUsecase,
    private val getCurrentSevenDays: GetCurrentSevenDays,
    private val saveUsernameUsecase: SaveUsernameUsecase,
    private val savePasswordUsecase: SavePasswordUsecase,
    private val getUsernameUsecase: GetUsernameUsecase,
    private val getPasswordUsecase: GetPasswordUsecase,
    private val saveUidUsecase: SaveUidUsecase,
    private val getUidUsecase: GetUidUsecase,
    private val setAuthenticatedStatusUsecase: SetAuthenticatedStatusUsecase,
    private val getAuthenticatedStatusUsecase: GetAuthenticatedStatusUsecase
) : ViewModel() {
    init {
        getCurrentSevenDays.getCurrentSevenDay()
    }
    fun isAuthenticated(): Boolean{
        return getAuthenticatedStatusUsecase.getAuthenticatedStatusUsecase()
    }

     suspend fun checkIfLoggedInBefore(navController: NavController, context: Context) {
        if (getUsernameUsecase.getUsernameUsecase()
                .isNotEmpty() && getPasswordUsecase.getPasswordUsecase()
                .isNotEmpty() && getUidUsecase.getUidUsecase().isNotEmpty()
        ) {
            navController.navigateToMainScreen(getUidUsecase.getUidUsecase(), emptyBackStack = true)
            this.login(email = getUsernameUsecase.getUsernameUsecase(), password = getPasswordUsecase.getPasswordUsecase(), context = context)
        }
    }

    private val _userData = MutableStateFlow(LoginUiState())
    val userData = _userData.asStateFlow()
    suspend fun login(email: String, password: String, context: Context) {
        try {
            val uid = loginUsecase.login(email, password)
            Log.i("jalal", "email is $email uid is $uid")
            _userData.update {
                it.copy(
                    username = email,
                    password = password,
                    uid = uid,
                    exception = false
                )
            }
        } catch (e: Exception) {
            Toast.makeText(context, e.message.toString(), Toast.LENGTH_LONG).show()
            Log.i("loginEx", e.message.toString())
        }

    }

    fun saveAuthenticatedData(userName: String, password: String, uid: String) {
        saveUsernameUsecase.saveUsernameUsecase(userName)
        savePasswordUsecase.savePasswordUsecase(password)
        saveUidUsecase.saveUidUsecase(uid = uid)
        setAuthenticatedStatusUsecase.setAuthenticatedStatusUsecase(isAuthenticate = true)
    }
}