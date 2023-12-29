package com.example.medicalapp.ui.screen.addPatientScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.DateRecyclerContent
import com.example.medicalapp.ui.compasible.GeneralButton
import com.example.medicalapp.ui.compasible.LoginTextFiled
import com.example.medicalapp.ui.compasible.VerticalSpacer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddPatientScreen(
    navController: NavController,
    viewModel: AddPatientViewModel = hiltViewModel()
) {
    val state by viewModel.addPatientState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    AddPatientContent(
        state = state,
        onClickAddPatien = {
            coroutineScope.launch {
                viewModel.addNewPatient()
            }
        },
        {
            viewModel.updateSelectedDate(it)
        }
        )
}

@Composable
fun AddPatientContent(
    state: AddPatientUiState,
    onClickAddPatien:() -> Unit,
    onSelectDate:(Int) -> Unit
    ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF9F9F9))
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        var patientName by remember { mutableStateOf(state.name) }
        var patientAge by remember { mutableStateOf(state.age) }
        var patientReservationTime by remember { mutableStateOf(state.reservationTime) }
        var patientReservationDate by remember { mutableStateOf(state.reservationDate) }

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
            LoginTextFiled(labelText = "اسم المراجع الثلاثي", value = patientName, textAlign = TextAlign.End, onValueChange = {
                state.name = it
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
                    LoginTextFiled(labelText = "الساعة", value = patientReservationTime, textAlign = TextAlign.End, onValueChange = {
                        state.reservationTime = it
                        patientReservationTime = it
                    },
                        )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                    ) {
                    BlackText(text = "العمر", size = 12)
                    VerticalSpacer(space = 8)
                    LoginTextFiled(labelText = "عمر المراجع", value = patientAge.toString(), textAlign = TextAlign.End, onValueChange = {
                        state.age = it.toInt()
                        patientAge = it.toInt()
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
            items(state.nextSevenDays.size){
                DateRecyclerContent(state.nextSevenDays[it].dayName,state.nextSevenDays[it].day,state.nextSevenDays[it].isSelected,onSelectDate,it)
            }
        }
        VerticalSpacer(space = 48)
        GeneralButton(text = "اضافة مراجع", onClickButton = onClickAddPatien)
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewPatientScreenStepOne() {

}