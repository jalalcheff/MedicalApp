package com.example.medicalapp.ui.screen

import android.os.Build
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicalapp.R
import com.example.medicalapp.ui.compasible.BlackText
import com.example.medicalapp.ui.compasible.DateRecyclerScreen
import com.example.medicalapp.ui.compasible.DoctorInfoCardScreen
import com.example.medicalapp.ui.compasible.HorizontalSpacer
import com.example.medicalapp.ui.compasible.LoadingState
import com.example.medicalapp.ui.compasible.MainIcons
import com.example.medicalapp.ui.compasible.PatientQueryCard
import com.example.medicalapp.ui.compasible.VerticalSpacer
import com.example.medicalapp.ui.screen.MainScreen.MainScreenUiState
import com.example.medicalapp.ui.screen.MainScreen.MainScreenViewModel
import com.example.medicalapp.ui.screen.addPatientScreen.navigateToAddPatientScreen
import com.example.medicalapp.ui.screen.settingsScreen.navigateToSettingsScreen
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    var name by remember {
        mutableStateOf(1)
    }
    BackPressHandler(onBackPressedDispatcher = (LocalContext.current as ComponentActivity).onBackPressedDispatcher) {
        // Handle back press as needed
        name++
        navController.navigateUp()
    }
    val state by viewModel.mainScreenData.collectAsState()
    val coroutine = rememberCoroutineScope()
    MainContent(
        state = state,
        onClickAddPatient = {
            navController.navigateToAddPatientScreen(state.uid)
            name++
        },
        onClickCard = {
            coroutine.launch { viewModel.updateCardState(it) }
        },
        onClickSettingsIcon = {
            navController.navigateToSettingsScreen(state.uid)
            name++
        }
    )
}

@Composable
fun MainContent(
    state: MainScreenUiState,
    onClickAddPatient: () -> Unit,
    onClickCard: (index: Int) -> Unit,
    onClickSettingsIcon: () -> Unit
) {

    Log.i("compasible", "days are ${state.nextSevenDays}")
    if (state.isLoading)
        LoadingState()
    else
        Column(
            modifier = Modifier
                .background(color = Color(0xFFF9F9F9))
                .padding(horizontal = 16.dp)
        ) {
            val patients = state.patients
            VerticalSpacer(space = 24)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row() {
                    MainIcons(imageUrl = R.drawable.setting_2_svgrepo_com, onClickICon = onClickSettingsIcon)
                    HorizontalSpacer(space = 8)
                    MainIcons(imageUrl = R.drawable.notification_svgrepo_com)
                }
                Image(
                    painter = painterResource(id = R.drawable.group_3),
                    contentDescription = "logo"
                )
            }
            VerticalSpacer(space = 24)
            DoctorInfoCardScreen(
                state.doctorName,
                state.docotorField,
                state.clincStartTime,
                state.clincEndTime,
                state.dayName,
                state.dayOfTheMonth,
                state.monthName
            )
            VerticalSpacer(space = 24)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                val nextSevenDaysState = state.nextSevenDays
                BlackText(text = "ايام تواجد الطبيب", size = 14)
                VerticalSpacer(space = 8)
                Log.i("compasible", "days size : ${state.nextSevenDays.size}")
                LazyRow(
                    content = {
                        items(nextSevenDaysState.size) {
                            DateRecyclerScreen(
                                day = state.nextSevenDays[it].dayName,
                                date = state.nextSevenDays[it].day,
                                isSelected = state.nextSevenDays[it].isSelected,
                                onClickCard,
                                index = it
                            )
                        }
                    },
                )
            }
            VerticalSpacer(space = 24)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                BlackText(text = "المراجعين", size = 14)
                VerticalSpacer(space = 24)
                Box() {
                    LazyColumn(
                        content = {
                            items(patients.size) {
                                PatientQueryCard(
                                    patientName = patients[it].name,
                                    query = patients[it].query,
                                    reservationDate = patients[it].reservationDate
                                )
                            }
                        },
                    )
                    FloatingActionButton(
                        onClick = onClickAddPatient,
                        containerColor = Color(0xFF18A0FB),
                        modifier = Modifier
                            .align(alignment = Alignment.BottomEnd)
                            .padding(bottom = 16.dp)
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_add_24),
                            contentDescription = "addPatient",
                            colorFilter = ColorFilter.tint(Color.White),
                        )
                    }
                }
            }


        }

}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewMainScreen() {
}
@Composable
fun BackPressHandler(
    onBackPressedDispatcher: OnBackPressedDispatcher,
    onBackPress: () -> Unit
) {
    val context = LocalContext.current

    DisposableEffect(context) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPress()
            }
        }

        onBackPressedDispatcher.addCallback(callback)

        onDispose {
            callback.remove()
        }
    }
}