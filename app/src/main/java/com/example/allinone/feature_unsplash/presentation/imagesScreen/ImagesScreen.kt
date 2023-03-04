package com.example.allinone.feature_unsplash.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.allinone.feature_unsplash.presentation.imagesScreen.components.ImagePostItem
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.allinone.feature_unsplash.presentation.destinations.DetailedImageScreenDestination
import com.example.allinone.feature_unsplash.presentation.detailedImageScreen.DetailedImageScreen
import com.example.allinone.feature_unsplash.presentation.imagesScreen.ImagesViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

private const val TAG = "ImagesScreen"

@Composable
@Destination(start = true)
fun ImageScreen(
    navigator: DestinationsNavigator,
    viewModel: ImagesViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    val lazyListState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState
        ){
            items(state.imagePosts) { imagePost ->
                if(imagePost.sponsorship != null) {
                    ImagePostItem(
                        photo = imagePost.urls.regular,
                        profileImage = imagePost.sponsorship.sponsor.profile_image.large,
                        user = imagePost.sponsorship.sponsor.username,
                        onClick = {
                            navigator.navigate(
                                DetailedImageScreenDestination(imagePost = imagePost)
                            )
                        }
                    )
                } else {
                    ImagePostItem(
                        photo = imagePost.urls.regular,
                        profileImage = imagePost.user.profile_image.large,
                        user = imagePost.user.username,
                        onClick = {
                            navigator.navigate(
                            DetailedImageScreenDestination(imagePost = imagePost)
                            )
                        }
                    )
                }
                if(lazyListState.firstVisibleItemIndex == state.imagePosts.size-3 && lazyListState.isScrollInProgress &&!state.isLoadingImages) {
                    viewModel.getImages()
                }

            }
        }
    }
    
}