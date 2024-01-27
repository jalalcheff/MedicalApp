package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R

@Composable
fun UnreachableErrorDialog(){
    Column(
        modifier = Modifier
            .background(Color(0xFFF9F9F9))
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box{}
            BlackText(text = "الأعدادات", size = 18)
            MainIcons(imageUrl = R.drawable.back_svgrepo_com__1_)
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.error_unreachable),
                contentDescription = "unreachable",
                alignment = Alignment.Center
            )
            VerticalSpacer(space = 16)
            BlackText(text =  "عذرًا، يبدو أنه لا يمكن الوصول\n إلى الإنترنت في الوقت الحالي", size = 14)
            GrayText(text = " يرجى التحقق من اتصالك بالإنترنت والمحاولة مرة أخرى", size = 10)
        }

        GeneralButton(text = "اعادة المحاولة", onClickButton = {})
    }
}

@Composable
@Preview
fun PreviewUnreachableErrorDialog(){
    UnreachableErrorDialog()
}