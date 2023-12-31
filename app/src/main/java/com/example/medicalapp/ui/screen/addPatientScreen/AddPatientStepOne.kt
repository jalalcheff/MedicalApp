package com.example.medicalapp.ui.screen.addPatientScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.DateRecyclerContent
import com.example.medicalapp.ui.compasible.GeneralButton
import com.example.medicalapp.ui.compasible.LoginTextFiled
import com.example.medicalapp.ui.compasible.VerticalSpacer

@Composable
fun AddPatientStepOneScreen() {

}

@Composable
fun AddPatientContentStepOne() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF9F9F9))
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        var patientName by remember { mutableStateOf("") }
        VerticalSpacer(space = 24)
        Image(
            painter = painterResource(id = R.drawable.slide),
            contentDescription = "slide",
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
            )
        VerticalSpacer(space = 24)
        Image(
            painter = painterResource(id = R.drawable.line_7),
            contentDescription = "line",
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.Center
            )
        VerticalSpacer(space = 24)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
            ) {
            BlackText(text = "الاسم الثلاثي", size = 12)
            VerticalSpacer(space = 8)
            LoginTextFiled(labelText = "اسم المراجع الثلاثي", value = patientName, onValueChange = {
                patientName = it
            })
            VerticalSpacer(space = 24)
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    horizontalAlignment = Alignment.End
                    ) {
                    BlackText(
                        text = "وقت الحجز",
                        size = 12,
                        )
                    VerticalSpacer(space = 8)
                    LoginTextFiled(labelText = "الساعة", value = patientName, onValueChange = {
                        patientName = it
                    },
                        )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                    ) {
                    BlackText(text = "العمر", size = 12)
                    VerticalSpacer(space = 8)
                    LoginTextFiled(labelText = "عمر المراجع", value = patientName, onValueChange = {
                        patientName = it
                    },)
                }
            }
        }
        VerticalSpacer(space = 24)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
            ) { BlackText(text = "يوم المعاينة", size = 12) }
        VerticalSpacer(space = 8)
        LazyRow(
            horizontalArrangement = Arrangement.End
        ){
            items(30){
                DateRecyclerContent()
            }
        }
        VerticalSpacer(space = 48)
        GeneralButton(text = "اضافة مراجع") {
            
        }
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewPatientScreenStepOne() {
    AddPatientContentStepOne()
}