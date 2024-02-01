package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.medicalapp.ui.extensionFunctions.shimmerEffect

@Composable
fun HomeLoadingLines(){
    Row(
        modifier = Modifier
            .height(17.dp)
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .shimmerEffect(color = 0x2aBBBBBB),
    ){}
    VerticalSpacer(space = 8)
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 32.dp)) {
        Row(modifier = Modifier.weight(0.5f)) {}
        Row(
            modifier = Modifier
                .height(17.dp)
                .weight(0.5f)
                .clip(shape = RoundedCornerShape(8.dp))
                .shimmerEffect(color = 0x2aBBBBBB),
            horizontalArrangement = Arrangement.End
        ){}
    }
    VerticalSpacer(space = 24)
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 32.dp)) {
        Row(modifier = Modifier.weight(0.5f)) {}
        Row(
            modifier = Modifier
                .height(34.dp)
                .weight(0.5f)
                .clip(shape = RoundedCornerShape(8.dp))
                .shimmerEffect(color = 0x2aBBBBBB),
            horizontalArrangement = Arrangement.End
        ){}
    }
}