package com.example.medicalapp.ui.compasible

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.medicalapplication.ui.theme.expoArabic

@Composable
fun BlackText(text: String, size: Int){
    Text(
        text = text,
        fontSize = size.sp,
        fontFamily = expoArabic,
        color = Color(0xBF000000),
        textAlign = TextAlign.End
    )
}