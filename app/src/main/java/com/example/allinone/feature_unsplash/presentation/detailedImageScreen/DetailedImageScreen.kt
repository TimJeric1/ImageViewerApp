package com.example.allinone.feature_unsplash.presentation.detailedImageScreen

import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import coil.compose.AsyncImage
import com.example.allinone.feature_unsplash.domain.model.ImagePost
import com.example.allinone.feature_unsplash.presentation.detailedImageScreen.components.DetailedImagePostItem
import com.example.allinone.feature_unsplash.presentation.imagesScreen.components.ImagePostItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailedImageScreen(
    imagePost: ImagePost
) {
    val context = LocalContext.current
    /*
    context.startActivity(
        Intent(Intent.ACTION_VIEW).also {
            it.data = Uri.parse(imagePost.urls.regular)
        }
    )*/

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        if(imagePost.sponsorship != null) {
            DetailedImagePostItem(
                photo = imagePost.urls.regular,
                profileImage = imagePost.sponsorship.sponsor.profile_image.large,
                user = imagePost.sponsorship.sponsor.username,
                onClick = {
                    context.startActivity(
                    Intent(Intent.ACTION_VIEW).also {
                        it.data = Uri.parse(imagePost.links.download)
                    }
                    )
                }
            )
        } else {
            DetailedImagePostItem(
                photo = imagePost.urls.regular,
                profileImage = imagePost.user.profile_image.large,
                user = imagePost.user.username,
                onClick = {
                    context.startActivity(
                        Intent(Intent.ACTION_VIEW).also {
                            it.data = Uri.parse(imagePost.urls.regular)
                        }
                    )}
            )
        }
    }

    }
