package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonQueryPatient(modifier: Modifier = Modifier, onChecked: (Int) -> Unit, query: Int = 0){
        Button(
            onClick = {onChecked(query)},
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF18A0FB)),
            modifier = modifier
        ) {
            WhiteText(text = "تمت المعاينة", size = 12)
        }
}

@Composable
@Preview
fun PreviewButtonQueryPatient(){
}