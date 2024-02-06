package com.example.medicalapp.ui.screen.loginScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
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
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController,
) {
    val context = LocalContext.current.applicationContext
    val state by viewModel.userData.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = true ){
        viewModel.checkIfLoggedInBefore(navController = navController, context = context)
    }
    LoginContent(
        state = state,
        onClickLogin = { email, password ->
            coroutineScope.launch {
                if (!state.exception) {
                    viewModel.saveAuthenticatedData(userName = email, password = password, uid = state.uid)
                    navController.navigateToMainScreen(viewModel.userData.value.uid, emptyBackStack = true)
                }
                viewModel.login(email = email, password = password, context = context)
            }
        }

    )

}

@Composable
fun LoginContent(
    state: LoginUiState,
    onClickLogin: (String, String) -> Unit,
) {
    Column() {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.medical_banner),
                contentDescription = "login_background",
            )
            Box(modifier = Modifier.offset(y = LocalConfiguration.current.screenHeightDp.dp / 3.toInt()))
            {
                LoginBottomSheet(
                    Modifier
                        .clip(shape = RoundedCornerShape(32.dp))
                        .background(Color.White)
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight(),
                    state.username,
                    state.password,
                    onClickLogin
                )
            }
        }
    }
}

@Preview(heightDp = 800, widthDp = 360)
@Composable
fun PreviewLogin() {
}
