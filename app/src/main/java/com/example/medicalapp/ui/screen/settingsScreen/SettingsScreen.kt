package com.example.medicalapp.ui.screen.settingsScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.DateRecyclerContent
import com.example.medicalapp.ui.compasible.HorizontalSpacer
import com.example.medicalapp.ui.compasible.LogOutDialog
import com.example.medicalapp.ui.compasible.LogoutLayerOnLayer
import com.example.medicalapp.ui.compasible.MainIcons
import com.example.medicalapp.ui.compasible.PatientQueryCard
import com.example.medicalapp.ui.compasible.SettingsChoiceComponent
import com.example.medicalapp.ui.compasible.VerticalSpacer
import com.example.medicalapp.ui.screen.MainScreen.navigateToMainScreen
import com.example.medicalapp.ui.screen.accountScreen.navigateToAccountScreen
import com.example.medicalapp.ui.screen.doctorInformationScreen.navigateToDoctorInformationScreen
import com.example.medicalapp.ui.screen.loginScreen.navigateToLoginScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsScreenViewModel = hiltViewModel(),
) {

    SettingsContent(
        onClickAccountSettings = {
            navController.navigateToAccountScreen(viewModel.getUid())
        },
        onClickDoctorInformation = {
            navController.navigateToDoctorInformationScreen(viewModel.getUid())
        },
        onClickLogout = {
            viewModel.clearAuthenticatedData()
            navController.navigateToLoginScreen(emptyBackStack = true)
        }
    )
}

@Composable
fun SettingsContent(
    onClickDoctorInformation: () -> Unit,
    onClickAccountSettings: () -> Unit,
    onClickLogout: () -> Unit,
) {
    var loginDialogStatus by remember {
        mutableStateOf(false)
    }
    if (loginDialogStatus)
        LogoutLayerOnLayer(onClickLogout = onClickLogout, onClickCancelLogout = {loginDialogStatus = false})
    else {
        Column(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Box {}
                BlackText(text = "الأعدادات", size = 18)
                MainIcons(imageUrl = R.drawable.back_svgrepo_com__1_)
            }
            VerticalSpacer(space = 24)
            SettingsChoiceComponent(
                settingChoiceText = "بيانات الطبيب",
                settingChoiceImage = R.drawable.doctor_information,
                onSettingsChoiceClick = onClickDoctorInformation
            )
            VerticalSpacer(space = 4)
            Image(
                painter = painterResource(id = R.drawable.line),
                contentDescription = "line",
                modifier = Modifier.fillMaxWidth()
            )
            SettingsChoiceComponent(
                settingChoiceText = "اعدادات الحساب",
                settingChoiceImage = R.drawable.settings,
                onSettingsChoiceClick = onClickAccountSettings
            )
            VerticalSpacer(space = 24)
            SettingsChoiceComponent(
                settingChoiceText = "تسجيل خروج",
                settingChoiceImage = R.drawable.log_out,
                onSettingsChoiceClick = {
                    loginDialogStatus = true
                }
            )

        }
    }
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    SettingsContent({}, {}, {})
}
