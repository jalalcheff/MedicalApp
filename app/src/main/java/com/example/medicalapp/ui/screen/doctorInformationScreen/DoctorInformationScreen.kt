package com.example.medicalapp.ui.screen.doctorInformationScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.GeneralButton
import com.example.medicalapp.ui.compasible.GrayText
import com.example.medicalapp.ui.compasible.MainIcons
import com.example.medicalapp.ui.compasible.VerticalSpacer

@Composable
fun DoctorInformationScreen(){

}

@Composable
fun DoctorInformationContent(){
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
            Box{}
            BlackText(text = "بيانات الطبيب", size = 18)
            MainIcons(imageUrl = R.drawable.back_svgrepo_com__1_)
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
        }

        GeneralButton(text = "تعديل", onClickButton = {})
    }
}

@Composable
@Preview
fun PreviewDoctorInformationContent(){
    DoctorInformationContent()
}