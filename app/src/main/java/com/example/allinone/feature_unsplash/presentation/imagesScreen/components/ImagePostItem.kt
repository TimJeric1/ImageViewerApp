package com.example.allinone.feature_unsplash.presentation.imagesScreen.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.allinone.ui.rememberWindowInfo

private const val TAG = "ImagePostItem"
@Composable
fun ImagePostItem(
    photo: String,
    profileImage: String,
    user: String,
    onClick: () -> Unit = {}
) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp, top = 16.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically)
                {
                
                AsyncImage(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape),
                    model = profileImage,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                )

                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = user,
                    color = Color.White.copy(alpha = 0.95f),
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.padding(top = 3.dp, bottom = 3.dp))
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { onClick() },
                model = photo,
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )

        }

}