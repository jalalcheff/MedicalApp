package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R
import com.example.medicalapp.ui.extensionFunctions.shimmerEffect

@Composable
fun LoadingState() {
    Column(modifier = Modifier.fillMaxSize()) {
        VerticalSpacer(space = 24)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .shimmerEffect(color = 0x2aBBBBBB),
                ){}
                Image(
                    painter = painterResource(id = R.drawable.group_3),
                    contentDescription = "logo"
                )
            }
        }
        VerticalSpacer(space = 24)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(156.dp)
                .padding(horizontal = 16.dp)
                .clip(shape = RoundedCornerShape(4.dp))
                .shimmerEffect(),
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(2.dp))
                            .padding(top = 4.dp)
                            .shimmerEffect(color = 0x2aBBBBBB)
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                        Box(
                            modifier = Modifier
                                .height(34.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .shimmerEffect(color = 0x2aBBBBBB),
                            )
                    }
                    HorizontalSpacer(space = 8)
                    Row(
                        modifier = Modifier
                            .size(45.dp)
                            .clip(shape = CircleShape)
                            .shimmerEffect(color = 0x2aBBBBBB),

                        ){}
                }
                VerticalSpacer(space = 12)
                   LoadingLine(height = 120)
                }
        }
        VerticalSpacer(space = 24)
        LoadingLine(height = 60)
        VerticalSpacer(space = 8)
        LazyRow() {
            items(10) {
                for (i in 0 until it)
                {
                    Row(
                        modifier = Modifier
                            .size(60.dp)
                            .padding(horizontal = 4.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                            .shimmerEffect(color = 0x2aBBBBBB),
                    ){}
                }
            }
        }
        VerticalSpacer(space = 24)
        Row(
            modifier = Modifier
                .height(17.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .shimmerEffect(color = 0x2aBBBBBB),
        ){}
        VerticalSpacer(space = 32)
        HomeLoadingLines()
        VerticalSpacer(space = 36)
        HomeLoadingLines()
        VerticalSpacer(space = 4)
        Row(
            modifier = Modifier
                .size(60.dp)
                .padding(bottom = 16.dp, start = 16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .shimmerEffect(color = 0x2aBBBBBB),
        ){}
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
fun PreviewLoadingState() {
    LoadingState()
}