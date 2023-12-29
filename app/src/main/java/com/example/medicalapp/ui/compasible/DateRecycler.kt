package com.example.medicalapp.ui.compasible

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DateRecyclerScreen(
    day: String,
    date: String,
    isSelected: Boolean,
    onClickCard: (index: Int) -> Unit,
    index: Int
){
    DateRecyclerContent(day,date,isSelected, onClickCard, index)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRecyclerContent(day: String, date: String, isSelected: Boolean, onClickCard:(index: Int)->Unit, index: Int){
    Log.i("cardColor", "color are : $isSelected")
    Card(
        modifier = Modifier
            .size(60.dp)
            .padding(end = 8.dp),
        colors =  when(isSelected) {
            true ->  CardDefaults.cardColors(Color(0xFF18A0FB))
            false ->  CardDefaults.cardColors(Color(0xFFFFFFFF))
        },
        onClick = {
            onClickCard(index)
        }
    ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    when (isSelected){
                        true ->{
                            WhiteText(text = day, 12)
                            WhiteText(text = date, size = 12)
                        }
                        false ->{
                            BlueText(text = day, 12)
                            BlueText(text = date, size = 12)
                        }
                    }

                }
            }
        }

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewDateRecycler(){

}