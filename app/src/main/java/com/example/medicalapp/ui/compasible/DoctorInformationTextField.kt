package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.medicalapp.R

@Composable
fun DoctorInformationTextField(
    textFieldName: String,
    trailingImageResource: Int,
    leadingImageResource: Int = 0,
    textFieldValue: String = "",
    onValueChange: (String)->Unit = {},
){
    LoginTextFiled(
        labelText = textFieldName,
        value = textFieldValue,
        onValueChange = onValueChange,
        trailingImageResource = {
            Image(
                painter = painterResource(id = trailingImageResource),
                contentDescription = "textField"
            )
        },
        leadingImageResource = {
            if (leadingImageResource != 0){
                Image(
                    painter = painterResource(id = leadingImageResource),
                    contentDescription = "textField"
                )
            }
        }
        )
}