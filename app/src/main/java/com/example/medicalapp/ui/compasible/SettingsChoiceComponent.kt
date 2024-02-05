package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R

@Composable
fun SettingsChoiceComponent(
    settingChoiceText: String,
    settingChoiceImage:Int,
    onSettingsChoiceClick: () -> Unit = {}
){
    Row(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onSettingsChoiceClick),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (settingChoiceText == "تسجيل خروج")
            RedText(text = settingChoiceText, size = 14)
        else
        BlackText(text = settingChoiceText, size = 14)
        HorizontalSpacer(space = 14)
        Image(
            painter = painterResource(id = settingChoiceImage),
            contentDescription = "settingChoice",
            modifier = Modifier.padding(vertical = 20.dp)
        )
    }
}

@Preview
@Composable
fun PreviewSettingsChoice(){
    SettingsChoiceComponent(settingChoiceText = "تسجيل خروج", settingChoiceImage =R.drawable.settings)
}