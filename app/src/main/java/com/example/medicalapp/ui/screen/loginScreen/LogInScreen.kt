package com.example.medicalapp.ui.screen.loginScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.medicalapp.R
import com.example.medicalapp.remote.RemoteDatasourceImp
import com.example.medicalapp.repository.RemoteDatasource
import com.example.medicalapp.ui.compasible.LoginBottomSheet
import com.example.medicalapp.ui.screen.MainScreen.navigateToMainScreen

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
){
    var counter by remember{ mutableStateOf(0) }
    Button(onClick = {
        counter++
        Log.i("jalal", "clicked me : ${viewModel.userData.value.uid}")
        navController.navigateToMainScreen(viewModel.userData.value.uid)
    }) {
        Text(text = "click me")
    }
    LaunchedEffect(key1 = counter)
    {
        viewModel.login("test@gmail.com", "12345678")
    }

}
@Composable
fun LoginContent(login: RemoteDatasource){
    Column() {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.medical_banner),
                contentDescription = "login_background",
            )
            Box(modifier = Modifier.offset(y = LocalConfiguration.current.screenHeightDp.dp/3.toInt()))
            {
                LoginBottomSheet(
                    Modifier
                        .clip(shape = RoundedCornerShape(32.dp))
                        .background(Color.White)
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight(),
                    login = login
                )
            }
        }
    }
}
@Preview(heightDp = 800, widthDp = 360)
@Composable
fun PreviewLogin(){
}
