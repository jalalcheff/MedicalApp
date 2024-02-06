package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicalapp.R

@Composable
fun ClincTimeTextfield(doctorEndTime: String, doctorStartTime: String, onClickStartTime: (String)->Unit, onClickEndTime: (String)->Unit) {
    var doctorStart by remember {
        mutableStateOf(doctorStartTime)
    }
    var doctorEnd by remember {
        mutableStateOf(doctorEndTime)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Box(modifier = Modifier.weight(0.5f)) {
            DoctorInformationTextField(
                textFieldName = "الى الساعة",
                trailingImageResource = R.drawable.working_time,
                textFieldValue = doctorStart,
                onValueChange = onClickStartTime
            )
        }
        HorizontalSpacer(space = 12)
        Box(modifier = Modifier.weight(0.5f)) {
            DoctorInformationTextField(
                textFieldName = "من الساعة",
                trailingImageResource = R.drawable.working_time,
                textFieldValue = doctorEnd,
                onValueChange = onClickEndTime
            )
        }
    }
}

@Composable
@Preview
fun PreviewClincTextField(){
    ClincTimeTextfield(
        doctorEndTime = "12:00",
        doctorStartTime = "22:00",
        onClickStartTime = {},
        onClickEndTime = {}
    )
}