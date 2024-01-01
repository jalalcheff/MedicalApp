package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R
import com.example.medicalapp.ui.extensionFunctions.shimmerEffect

@Composable
fun LoadingState(){
Column(modifier = Modifier.fillMaxSize()) {
    VerticalSpacer(space = 24)

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row() {
            Box(modifier = Modifier
                .size(32.dp)
                .shimmerEffect())
            HorizontalSpacer(space = 8)
            Box(modifier = Modifier
                .size(32.dp)
                .shimmerEffect())
        }
        Box(modifier = Modifier
            .size(32.dp)
            .shimmerEffect())
    }
    VerticalSpacer(space = 24)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(156.dp)
            .padding(horizontal = 16.dp)
            .shimmerEffect()
    )
    VerticalSpacer(space = 24)
    LazyColumn(){
        items(10){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .padding(horizontal = 16.dp)
                    .shimmerEffect()
                    .padding(vertical = 8.dp)
            )
        }
    }
}
}
@Preview(widthDp = 360, heightDp = 800)
@Composable
fun PreviewLoadingState(){
    LoadingState()
}