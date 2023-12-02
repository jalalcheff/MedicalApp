package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QueryHashtag(){
    Card(
        colors = CardDefaults.cardColors(Color(0xFFFDEFEF)),
        shape = RoundedCornerShape(4.dp),
        ) {
        HashtagText(text = "#1", color = 0xFFEA5B5B)
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewQueryHashtag(){
    QueryHashtag()
}