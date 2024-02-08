package com.example.medicalapp.ui.screen.accountScreen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.DoctorInformationTextField
import com.example.medicalapp.ui.compasible.GeneralButton
import com.example.medicalapp.ui.compasible.MainIcons
import com.example.medicalapp.ui.compasible.VerticalSpacer
import com.example.medicalapp.ui.screen.MainScreen.navigateToMainScreen
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AccountScreen(
    navController: NavController,
    viewModel: AccountScreenViewModel = hiltViewModel(),
) {
    val coroutine = rememberCoroutineScope()
    val context = LocalContext.current
    val state by viewModel.accountScreenData.collectAsState()
    AccountContent(
        state = state,
        onClickEdit = {
            coroutine.launch {
                val isPasswordChanged = viewModel.changePassword()
                if (isPasswordChanged){
                    navController.navigateToMainScreen(uid = state.uid, emptyBackStack = true)
                    Toast.makeText(context, "تم تغيير كلمة المرور بنجاح", Toast.LENGTH_LONG).show()
            }
                else{
                    Toast.makeText(context, "خطأ في تفيير كلمة المرور", Toast.LENGTH_LONG).show()
                }
            }
        }
    )
}

@Composable
fun AccountContent(state: AccountScreenUiState, onClickEdit: () -> Unit) {
    Column(
        modifier = Modifier
            .background(Color(0xFFF9F9F9))
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var oldEnterdPassword by remember {
            mutableStateOf(state.oldEnteredPassword)
        }
        var newEnteredPassword by remember {
            mutableStateOf(state.newPassword)
        }
        var confirmedNewEnteredPassword by remember {
            mutableStateOf(state.confirmedNewPassword)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box {}
            BlackText(text = "بيانات الطبيب", size = 18)
            MainIcons(imageUrl = R.drawable.back_svgrepo_com__1_)
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BlackText(
                text = "لتحسين أمان حسابك، يُفضل تغيير كلمة المرور بشكل دوري. الرجاء اتباع الخطوات أدناه لتغيير كلمة المرور الخاصة بك",
                size = 14
            )
            VerticalSpacer(space = 24)
            DoctorInformationTextField(
                textFieldName = "ادخل كلمة المرور الحالية",
                trailingImageResource = R.drawable.lock,
                leadingImageResource = R.drawable.eye_svgrepo_com,
                textFieldValue = oldEnterdPassword,
                onValueChange = {
                    oldEnterdPassword = it
                    state.oldEnteredPassword = it
                }
            )
            VerticalSpacer(space = 16)
            DoctorInformationTextField(
                textFieldName = "ادخل كلمة المرور الجديدة",
                trailingImageResource = R.drawable.lock,
                leadingImageResource = R.drawable.eye_svgrepo_com,
                textFieldValue = newEnteredPassword,
                onValueChange = {
                    newEnteredPassword = it
                    state.newPassword = it
                }
            )
            VerticalSpacer(space = 16)
            DoctorInformationTextField(
                textFieldName = "ادخل تاكيد كلمة المرور الجديدة",
                trailingImageResource = R.drawable.lock,
                leadingImageResource = R.drawable.eye_svgrepo_com,
                textFieldValue = confirmedNewEnteredPassword,
                onValueChange = {
                    confirmedNewEnteredPassword = it
                    state.confirmedNewPassword = it
                }
            )
        }

        GeneralButton(text = "تعديل", onClickButton = onClickEdit)
    }
}

@Composable
@Preview
fun PreviewAccountContent() {
    AccountContent(AccountScreenUiState(), {})
}