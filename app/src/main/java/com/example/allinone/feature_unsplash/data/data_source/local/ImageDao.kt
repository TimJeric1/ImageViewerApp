package com.example.allinone.feature_unsplash.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.allinone.feature_unsplash.domain.model.ImagePost


@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertImagePosts(
        imagePosts: List<ImagePost>
    )
    @Query(
        "SELECT * FROM imagepost"
    )
    suspend fun GetImagePosts(): List<ImagePost>


    @Query("DELETE FROM ImagePost")
    suspend fun ClearImagePosts()


}