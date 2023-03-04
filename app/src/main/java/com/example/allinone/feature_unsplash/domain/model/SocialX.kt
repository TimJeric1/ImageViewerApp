package com.example.allinone.feature_unsplash.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SocialX(
    val instagram_username: String,
    val portfolio_url: String,
    val twitter_username: String
): Parcelable