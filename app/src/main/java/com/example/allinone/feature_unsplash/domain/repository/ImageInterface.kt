package com.example.allinone.feature_unsplash.domain.repository

import com.example.allinone.feature_unsplash.Util.Resource
import com.example.allinone.feature_unsplash.domain.model.ImagePost
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ImageInterface {

    suspend fun getImagePosts(
        page: Int,
        fetchFromRemote: Boolean,
        query: String,
        order: String
    ): Flow<Resource<List<ImagePost>>>



}