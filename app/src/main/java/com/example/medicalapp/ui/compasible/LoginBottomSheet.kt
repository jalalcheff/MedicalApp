package com.example.medicalapp.ui.compasible

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicalapp.R
import com.example.medicalapp.remote.RemoteDatasourceImp
import com.example.medicalapp.repository.RemoteDatasource
import com.example.medicalapp.ui.screen.loginScreen.ILogin
import com.example.medicalapp.ui.screen.loginScreen.LoginUiState
import com.example.medicalapplication.ui.theme.expoArabic

@Composable
fun LoginBottomSheet(
    modifier: Modifier = Modifier
        .clip(shape = RoundedCornerShape(32.dp))
        .background(Color.White)
        .fillMaxHeight()
        .padding(horizontal = 16.dp),
    usernameArg: String,
    passwordArg: String,
    onClickLogin: (String, String) -> Unit
) {
    Column(
        modifier = modifier
    )
    {
        var buttonClick by remember { mutableStateOf(0) }
        var email by remember { mutableStateOf(usernameArg) }
        var password by remember { mutableStateOf(passwordArg) }
        VerticalSpacer(space = 32)
        Text(
            text = "اهلا بك ! الرجاء ادخال البريد الالكتروني وكلمة المرور الخاصة بك لتسجيل الدخول",
            fontSize = 14.sp,
            color = Color(0xBF000000),
            textAlign = TextAlign.End,
            fontFamily = expoArabic
        )
        VerticalSpacer(space = 24)
        Text(
            text = "البريد الالكتروني",
            fontSize = 14.sp,
            color = Color(0xBF000000),
            textAlign = TextAlign.End,
            fontFamily = expoArabic,
            modifier = Modifier.fillMaxWidth()
        )
        LoginTextFiled(
            labelText = "ادخل البريد الالكتروني",
            trailingImageResource = {
                Image(
                    painter = painterResource(id = R.drawable.email_svgrepo_com),
                    contentDescription = "background"
                )},
            value = email,
            onValueChange = {
                email = it
            }
        )
        VerticalSpacer(space = 16)
        Text(
            text = "كلمة المرور",
            fontSize = 14.sp,
            fontFamily = expoArabic,
            color = Color(0xBF000000),
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
        LoginTextFiled(
            labelText = "ادخل كلمة المرور",
            trailingImageResource = {
                Image(
                    painter = painterResource(id = R.drawable.lock),
                    contentDescription = "background"
                )},
            leadingImageResource = {
                Image(
                    painter = painterResource(id = R.drawable.eye_svgrepo_com),
                    contentDescription = "background"
                )
            },
            value = password,
            onValueChange = {
                password = it
            }
        )
        VerticalSpacer(space = 48)
        Button(
            onClick = {
               onClickLogin(email, password)
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF18A0FB)),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "تسجيل الدخول",
                fontFamily = expoArabic
            )
        }
     /*   LaunchedEffect(buttonClick) {
            if (email.isNotEmpty() && password.isNotEmpty())
                login.signIn(email = email, password = password)
        }*/
    }
}

@Composable
@Preview(heightDp = 800, widthDp = 360)
fun PreviewLoginBottomSheet() {
}