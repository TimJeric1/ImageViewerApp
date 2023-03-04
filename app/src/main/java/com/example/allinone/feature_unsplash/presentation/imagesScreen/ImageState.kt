package com.example.allinone.feature_unsplash.presentation.imagesScreen

import com.example.allinone.feature_unsplash.domain.model.ImagePost

data class ImageState(
    val imagePosts: List<ImagePost> = emptyList(),
    val isLoadingImages: Boolean = false,
    val pageNumber: Int = 1,
    val searchQuery: String = ""
)
