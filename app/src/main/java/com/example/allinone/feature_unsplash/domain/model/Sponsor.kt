package com.example.allinone.feature_unsplash.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sponsor(
    val id: String = "",
    val profile_image: ProfileImage = ProfileImage("","",""),
    val username: String = ""
): Parcelable