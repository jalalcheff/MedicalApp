package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.medicalapp.ui.extensionFunctions.shimmerEffect

@Composable
fun LoadingLine(height: Int){
    Box(
        modifier = Modifier
            .height(height.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .shimmerEffect(color = 0x2aBBBBBB),
    )
}