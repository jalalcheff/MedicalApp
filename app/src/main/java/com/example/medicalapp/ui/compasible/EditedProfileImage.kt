package com.example.medicalapp.ui.compasible

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicalapp.R

@Composable
fun EditedProfileImage(imageResource: Int) {
    Box() {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "doctorImage",
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(120.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.camera),
            contentDescription = "camera",
            modifier = Modifier
                .background(shape = CircleShape, color = Color.White)
                .padding(4.dp)
                .align(Alignment.BottomEnd)
        )
    }

}

@Composable
@Preview
fun PreviewEditedProfileImage() {
    EditedProfileImage(R.drawable.doctor_image)
}