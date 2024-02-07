package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.medicalapp.R

@Composable
fun LogoutComposable() {/*   Box(
           modifier = Modifier.zIndex(1f),
           contentAlignment = Alignment.Center
       ) {
           LogOutDialog()
       }*/
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.3f))
            .zIndex(2f)
    )
    Column(
        modifier = Modifier
            .background(Color(0xFFF9F9F9))
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box {}
            BlackText(text = "الأعدادات", size = 18)
            MainIcons(imageUrl = R.drawable.back_svgrepo_com__1_)
        }
        VerticalSpacer(space = 24)
        SettingsChoiceComponent(settingChoiceText = "بيانات الطبيب",
            settingChoiceImage = R.drawable.doctor_information,
            onSettingsChoiceClick = {})
        VerticalSpacer(space = 4)
        Image(
            painter = painterResource(id = R.drawable.line),
            contentDescription = "line",
            modifier = Modifier.fillMaxWidth()
        )
        SettingsChoiceComponent(settingChoiceText = "اعدادات الحساب",
            settingChoiceImage = R.drawable.settings,
            onSettingsChoiceClick = {})
        VerticalSpacer(space = 24)
        SettingsChoiceComponent(settingChoiceText = "تسجيل خروج",
            settingChoiceImage = R.drawable.log_out,
            onSettingsChoiceClick = {})
    }
}

@Composable
fun LogoutLayerOnLayer(onClickLogout: () -> Unit, onClickCancelLogout: () -> Unit) {
    Box(
        modifier = Modifier
            .zIndex(1f)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        LogOutDialog(onClickLogout = onClickLogout, onClickCancelLogout = onClickCancelLogout)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        LogoutComposable()
    }

}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewLogoutComposable() {
    LogoutLayerOnLayer({},{})
}