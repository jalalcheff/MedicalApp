package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R

@Composable
fun MainIcons(imageUrl: Int, onClickICon: ()->Unit = {}){
Card(
    shape = RoundedCornerShape(size = 8.dp),
    colors = CardDefaults.cardColors(Color(0x3DBBBBBB)),
) {
    Image(
        painter = painterResource(id = imageUrl),
        contentDescription = "settings",
        modifier = Modifier.padding(8.dp).clickable(onClick = onClickICon),
    )
}
}
@Composable
@Preview
fun PreviewMainIcon(){
    MainIcons(R.drawable.setting_2_svgrepo_com)
}
