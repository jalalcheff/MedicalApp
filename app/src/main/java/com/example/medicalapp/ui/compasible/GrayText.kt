package com.example.medicalapp.ui.compasible

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.medicalapplication.ui.theme.expoArabic

@Composable
fun GrayText(text: String, size: Int){
    Text(
        style = TextStyle(
            fontSize = size.sp,
            fontFamily = expoArabic,
            fontWeight = FontWeight(400),
            color = Color(0x4D000000),
            textAlign = TextAlign.Right,
        ),
        text = text
    )
}