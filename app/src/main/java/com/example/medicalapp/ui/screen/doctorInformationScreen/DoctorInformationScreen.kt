package com.example.medicalapp.ui.screen.doctorInformationScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.DoctorInformationTextField
import com.example.medicalapp.ui.compasible.EditedProfileImage
import com.example.medicalapp.ui.compasible.GeneralButton
import com.example.medicalapp.ui.compasible.GrayText
import com.example.medicalapp.ui.compasible.HomeLoadingLines
import com.example.medicalapp.ui.compasible.LoginTextFiled
import com.example.medicalapp.ui.compasible.MainIcons
import com.example.medicalapp.ui.compasible.VerticalSpacer

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DoctorInformationScreen(
    navController: NavController,
    viewModel: DoctorInformationScreenViewModel = hiltViewModel(),
){
    val state by viewModel.informationScreenData.collectAsState()
    DoctorInformationContent(
        state
    ) { doctorName, doctorField, doctorExistenceTime ->

    }
}

@Composable
fun DoctorInformationContent(
    state: DoctorInformationUiState,
    onClickEdit: (String, String, String) -> Unit
){
    if (state.isLoading){
     HomeLoadingLines()
    }
    else {
        var doctorName by remember {
            mutableStateOf(state.doctorName)
        }
        var doctorField by remember {
            mutableStateOf(state.doctorField)
        }
        var doctorExistenceTime by remember {
            mutableStateOf(state.doctorExistenceTime)
        }
        Column(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .padding(horizontal = 16.dp, vertical = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
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
                EditedProfileImage(imageResource = R.drawable.doctor_image)
                VerticalSpacer(space = 48)
                DoctorInformationTextField(
                    textFieldName = "اسم الطبيب",
                    trailingImageResource = R.drawable.doctor_name,
                    textFieldValue = doctorName,
                    onValueChange = {
                        doctorName = it
                    }
                )
                VerticalSpacer(space = 16)
                DoctorInformationTextField(
                    textFieldName = "التخصص",
                    trailingImageResource = R.drawable.doctor_field,
                    textFieldValue = doctorField,
                    onValueChange = {
                        doctorField = it
                    }
                )
                VerticalSpacer(space = 16)
                DoctorInformationTextField(
                    textFieldName = "وقت العمل",
                    trailingImageResource = R.drawable.working_time,
                    textFieldValue = state.doctorExistenceTime,
                    onValueChange = {
                        doctorExistenceTime = it
                    }
                )
                VerticalSpacer(space = 16)
                DoctorInformationTextField(
                    textFieldName = "ايام العمل",
                    trailingImageResource = R.drawable.working_days,
                    textFieldValue = state.doctorExistenceDate
                )
            }

            GeneralButton(
                text = "تعديل",
                onClickButton = { onClickEdit(doctorName, doctorField, doctorExistenceTime) }
            )
        }
    }
}

@Composable
@Preview
fun PreviewDoctorInformationContent(){
}