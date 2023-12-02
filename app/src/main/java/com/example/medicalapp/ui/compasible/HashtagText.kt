package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicalapplication.ui.theme.expoArabic

@Composable
fun HashtagText(text: String, color: Long){
    Text(
        modifier = Modifier.padding(4.dp),
        text = text,
        fontSize = 12.sp,
        fontFamily = expoArabic,
        color = Color(color = color),
        textAlign = TextAlign.End,
    )
}