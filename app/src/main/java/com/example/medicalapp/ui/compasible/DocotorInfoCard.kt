package com.example.medicalapp.ui.compasible

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R

@Composable
fun DoctorInfoCardScreen(
    doctorName: String,
    fieldName: String,
    clincStartTime: String,
    clincEndTime: String,
    dayName: String,
    dayOfTheMonth: String,
    monthName: String,
){
DoctorInfoCardContent(doctorName, fieldName, clincStartTime, clincEndTime,dayName, dayOfTheMonth, monthName)
}

@Composable
fun DoctorInfoCardContent(
    doctorName: String,
    fieldName: String,
    clincStartTime: String,
    clincEndTime: String,
    dayName: String,
    dayOfTheMonth: String,
    monthName: String,
){
Box(modifier = Modifier.fillMaxWidth()) {
    Image(
        painter = painterResource(id = R.drawable.frame_11),
        contentDescription = "frame",
        modifier = Modifier.fillMaxWidth()
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp, top = 24.dp, start = 16.dp),
        horizontalAlignment = Alignment.End,
    ) {
        Row() {
            Column(horizontalAlignment = Alignment.End) {
                WhiteText(text = doctorName, size = 14)
                WhiteText(text = fieldName, size = 12)
            }
            HorizontalSpacer(space = 12)
            Image(
                painter = painterResource(id = R.drawable.doctor_image),
                contentDescription = "doctor_image",
                modifier = Modifier
                    .clip(RoundedCornerShape(45.dp))
                    .size(45.dp),
                alignment = Alignment.TopEnd
            )
        }
        VerticalSpacer(space = 12)
        Card(
            modifier = Modifier.height(44.dp),
            colors = CardDefaults.cardColors(Color(0xFF42B3FF)),
            shape = RoundedCornerShape(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DateTimeDoctor(imageUrl = R.drawable.clock_nine_svgrepo_com, text = "$clincStartTime - $clincEndTime")
                DateTimeDoctor(imageUrl = R.drawable.calendar, text = "$monthName $dayOfTheMonth, $dayName")
            }
        }
    }
}
}

@Composable
@Preview
fun PreviewDoctorInfoScreen(){
    DoctorInfoCardContent("","","","","","","")
}