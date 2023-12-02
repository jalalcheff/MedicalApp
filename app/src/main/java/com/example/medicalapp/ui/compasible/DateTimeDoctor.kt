package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R

@Composable
fun DateTimeDoctor(imageUrl: Int, text: String){
            Row(
                 modifier = Modifier.padding(vertical = 12.dp).padding(end = 24.dp, start = 24.dp)
            ) {
                WhiteText(text = text, size = 12)
                HorizontalSpacer(space = 4)
                Image(painter = painterResource(id = imageUrl), contentDescription = "calender")
            }


}