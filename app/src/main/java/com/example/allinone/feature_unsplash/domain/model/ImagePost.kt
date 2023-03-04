package com.example.allinone.feature_unsplash.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class ImagePost(
    val alt_description: String? = "",
    val description: String? = "",
    @PrimaryKey val id: String,
    val likes: Int,
    val links: Links,
    val sponsorship: Sponsorship? = Sponsorship(sponsor = Sponsor()),
    val urls: Urls,
    val user: User,

    ): Parcelable
