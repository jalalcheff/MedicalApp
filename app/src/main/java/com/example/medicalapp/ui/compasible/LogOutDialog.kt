package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LogOutDialog(){
    Card(colors = CardDefaults.cardColors(Color.White)) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BlackText(text = "هل أنت متأكد أنك تريد تسجيل الخروج؟", size = 14)
            VerticalSpacer(space = 32)
            Row {
                OutlinedButtonLogOut(text = "اللغاء")
                HorizontalSpacer(space = 12)
                LogOutButton(text = "تسحيل خروح") {
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewLogOutDialog(){
    LogOutDialog()
}