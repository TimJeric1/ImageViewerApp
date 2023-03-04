package com.example.allinone.feature_unsplash.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.allinone.feature_unsplash.domain.model.ImagePost


@Database(
    entities = [ImagePost::class],
    version = 1
)
abstract class ImageDatabase: RoomDatabase() {

    abstract val dao: ImageDao

}