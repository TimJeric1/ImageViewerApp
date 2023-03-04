package com.example.allinone.feature_unsplash.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileImageX(
    val large: String,
    val medium: String,
    val small: String
): Parcelable