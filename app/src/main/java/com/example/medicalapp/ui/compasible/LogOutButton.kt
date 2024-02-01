package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapplication.ui.theme.expoArabic

@Composable
fun LogOutButton(
    text: String,
    onClickButton: ()-> Unit
){
    Button(
        onClick = onClickButton,
        colors = ButtonDefaults.buttonColors(Color(0xFFEA5B5B)),
        shape = RoundedCornerShape(4.dp),
        contentPadding = PaddingValues(vertical = 11.dp, horizontal = 24.dp)
    ) {
        WhiteText(
            text = text,
            size = 14
        )
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewLogOut(){
    LogOutButton("تسحيل خروج", {})
}