package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DateRecyclerScreen(
    day: String,
    date: String
){
    DateRecyclerContent(day,date)
}

@Composable
fun DateRecyclerContent(day: String, date: String){
    Card(
        modifier = Modifier
            .size(60.dp)
            .padding(end = 8.dp),
        colors = CardDefaults.cardColors(Color(0xFF18A0FB)),
        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            WhiteText(text = day, 12)
            WhiteText(text = date, size = 12)
        }
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewDateRecycler(){
    DateRecyclerContent( "الاربعاء","13")
}