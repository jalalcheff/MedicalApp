package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp
import com.example.medicalapp.R
import com.example.medicalapplication.ui.theme.expoArabic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextFiled(
     labelText: String,
     trailingImageResource: @Composable (() -> Unit)? = null,
     value: String,
     onValueChange: (String) -> Unit,
     leadingImageResource: @Composable (() -> Unit)? = null,
     textAlign: TextAlign = TextAlign.Start
){
    OutlinedTextField(
        value = value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray.copy(alpha = 0.8f),
            unfocusedBorderColor = Color.Gray.copy(alpha = 0.2f)
        ),
        label ={
            Text(text = labelText,
                fontSize = 14.sp,
                color = Color(0xBF000000),
                textAlign = TextAlign.End,
                fontFamily = expoArabic,
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.5f))
        },
        onValueChange = onValueChange,
        textStyle = TextStyle(fontFamily = expoArabic, textAlign = textAlign, textDirection = TextDirection.Content),
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = trailingImageResource,
        leadingIcon = leadingImageResource
        )
}