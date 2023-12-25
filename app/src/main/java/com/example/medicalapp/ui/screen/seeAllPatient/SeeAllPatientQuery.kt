package com.example.medicalapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.DateRecyclerContent
import com.example.medicalapp.ui.compasible.MainIcons
import com.example.medicalapp.ui.compasible.PatientQueryCard
import com.example.medicalapp.ui.compasible.VerticalSpacer

@Composable
fun SeeAllPatientQueryScreen() {

}

@Composable
fun SeeAllPatientQueryContent() {
    Column(
        modifier = Modifier
            .background(Color(0xFFF9F9F9))
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "")
            BlackText(text = "المراجعين", size = 18)
            MainIcons(imageUrl = R.drawable.back_svgrepo_com__1_)
        }
        VerticalSpacer(space = 24)
        LazyRow(
            content = {
                items(10) {
                    for (i in 0..10) {
                        DateRecyclerContent("","",false)
                    }
                }
            },
        )
        VerticalSpacer(space = 24)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            LazyColumn(
                content = {
                    items(10) {
                        for (i in 0..10) {
                            PatientQueryCard("",0,"")
                        }
                    }
                },
            )

        }

    }
}
@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewAllPatientQuery() {
    SeeAllPatientQueryContent()
}