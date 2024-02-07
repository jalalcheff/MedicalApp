package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
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
fun OutlinedButtonLogOut(modifier: Modifier = Modifier, text: String,onClickCancelLogout: () -> Unit = {}){
        OutlinedButton(
            modifier = modifier,
            onClick = onClickCancelLogout,
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(1.dp, Color(0x4D000000)),
            contentPadding = PaddingValues(vertical = 11.dp, horizontal = 46.dp)
        ) {
            BlackText(text = text, size = 12)
        }
}

@Composable
@Preview
fun PreviewOutlinedButtonLogOut(){
}