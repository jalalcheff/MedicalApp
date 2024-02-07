package com.example.medicalapp.local

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.medicalapp.repository.SharedPreferenceService
import javax.inject.Inject

class SharedPreferenceImp @Inject constructor(private val sharedPreferences: SharedPreferences):SharedPreferenceService {
    override fun saveUserName(userName: String) {
        sharedPreferences.edit {
            putString("name", userName)
        }
    }

    override fun savePassword(password: String) {
        sharedPreferences.edit{
            putString("password", password)
        }
    }

    override fun saveUid(uid: String) {
        sharedPreferences.edit{
            putString("uid", uid)
        }
    }

    override fun setAuthenticatedStatus(isAuthenticate: Boolean) {
        sharedPreferences.edit{
            putBoolean("isAuthenticated", isAuthenticate)
        }
    }

    override fun getUserName(): String {
        return sharedPreferences.getString("name", null) ?: ""
    }

    override fun getPassword(): String {
        return sharedPreferences.getString("password", null) ?: ""
    }

    override fun getUid(): String {
        return sharedPreferences.getString("uid", null) ?: ""
    }

    override fun isAuthenticated(): Boolean {
        return sharedPreferences.getBoolean("isAuthenticated", false)
    }
}