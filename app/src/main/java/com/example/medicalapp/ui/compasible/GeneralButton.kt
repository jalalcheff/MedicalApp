package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.medicalapplication.ui.theme.expoArabic

@Composable
fun GeneralButton(text: String, onClickButton: ()-> Unit){
    Button(
        onClick = onClickButton,
        colors = ButtonDefaults.buttonColors(Color(0xFF18A0FB)),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            fontFamily = expoArabic
        )
    }
}