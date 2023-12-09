package com.example.medicalapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.DateRecyclerContent
import com.example.medicalapp.ui.compasible.DateRecyclerScreen
import com.example.medicalapp.ui.compasible.DoctorInfoCardContent
import com.example.medicalapp.ui.compasible.DoctorInfoCardScreen
import com.example.medicalapp.ui.compasible.HorizontalSpacer
import com.example.medicalapp.ui.compasible.MainIcons
import com.example.medicalapp.ui.compasible.PatientQueryContent
import com.example.medicalapp.ui.compasible.VerticalSpacer
import com.example.medicalapp.ui.screen.MainScreen.MainScreenUiState
import com.example.medicalapp.ui.screen.MainScreen.MainScreenViewModel

@Composable
fun MainScreen(
     viewModel: MainScreenViewModel = hiltViewModel(),
){
    val state by viewModel.mainScreenData.collectAsState()
    MainContent(state)
}

@Composable
fun MainContent(state: MainScreenUiState){
    Column(
        modifier = Modifier
            .background(color = Color(0xFFF9F9F9))
            .padding(horizontal = 16.dp)
    ) {
        VerticalSpacer(space = 24)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row() {
                MainIcons(imageUrl = R.drawable.setting_2_svgrepo_com)
                HorizontalSpacer(space = 8)
                MainIcons(imageUrl = R.drawable.notification_svgrepo_com)
            }
            Image(painter = painterResource(id = R.drawable.group_3), contentDescription = "logo")
        }
        VerticalSpacer(space = 24)
        DoctorInfoCardScreen(state.doctorName, state.docotorField, state.clincStartTime, state.clincEndTime, state.dayName, state.dayOfTheMonth, state.monthName)
        VerticalSpacer(space = 24)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            BlackText(text = "ايام تواجد الطبيب", size = 14)
            VerticalSpacer(space = 8)
            LazyRow(
                content = {
                    items(10) {
                        for (i in 0..10) {
                            DateRecyclerScreen(day = state.dayName, date = state.dayOfTheMonth)
                        }
                    }
                },
            )
        }
        VerticalSpacer(space = 24)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
        ) {
        BlackText(text = "المراجعين", size = 14)
        VerticalSpacer(space = 24)
        LazyColumn(
            content = {
                items(10) {
                    for (i in 0..10) {
                        PatientQueryContent()
                    }
                }
            },
        )

    }


    }

}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewMainScreen(){
    MainContent(MainScreenUiState())
}