package com.example.allinone.feature_unsplash.presentation.detailedImageScreen.components

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.allinone.feature_unsplash.domain.model.ImagePost

@Composable
fun DetailedImagePostItem(
    photo: String,
    onClick: () -> Unit = {},
    profileImage: String,
    user: String,

) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Bottom
        ) {

            AsyncImage(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape),
                model = profileImage,
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )

            Text(
                text = user,
                color = Color.White.copy(alpha = 0.95f),
                textAlign = TextAlign.Right,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(),
            model = photo,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Row(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(end = 16.dp, top = 16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            Button(
                onClick = onClick,
                modifier = Modifier
                    .width(86.dp)
                    .height(32.dp),
                shape = RectangleShape,
            ) {
                Text(
                    text = "Download",
                    color = Color.White.copy(alpha = 0.95f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }

    }


}