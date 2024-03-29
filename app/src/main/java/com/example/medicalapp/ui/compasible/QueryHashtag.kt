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
fun QueryHashtag(query: Int) {
    Card(
        colors =
        when (query) {
            1 -> CardDefaults.cardColors(Color(0xFFFDEFEF))
            else -> CardDefaults.cardColors(Color(0xFFE8F6FF))
        },
        shape = RoundedCornerShape(4.dp),
    ) {
        when (query) {
            1 -> HashtagText(text = "#$query", color = 0xFFEA5B5B)
            else -> HashtagText(text = "#$query", color = 0xFF18A0FB)
        }
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewQueryHashtag() {
    QueryHashtag(2)
}