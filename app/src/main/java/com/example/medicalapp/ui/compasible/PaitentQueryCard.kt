package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R

@Composable
fun PatientQueryCard(
    patientName: String,
    query: Int,
    reservationDate: String
){
Card(
    colors = CardDefaults.cardColors(Color(0xFFFEFEFE)),
    modifier = Modifier.padding(bottom = 12.dp)
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            QueryHashtag(query)
            BlackText(text = patientName, size = 16)
        }
        VerticalSpacer(space = 20)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
            ) {
            Image(painter = painterResource(id = R.drawable.booking), contentDescription = "booking")
            HorizontalSpacer(space = 4)
            BlackText(text = reservationDate, size = 10)
        }
        VerticalSpacer(space = 20)
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            OutlinedButtonQueryPatient(Modifier.weight(1f).padding(end = 8.dp))
            ButtonQueryPatient(Modifier.weight(1f))
        }
    }
}
}

@Composable
@Preview (widthDp = 360, heightDp = 800)
fun PreviewPatientQuery(){
    PatientQueryCard("",0,"")
}