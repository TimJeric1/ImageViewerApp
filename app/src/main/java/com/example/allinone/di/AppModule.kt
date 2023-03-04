package com.example.allinone.di

import android.app.Application
import androidx.room.Room
import com.example.allinone.feature_unsplash.data.data_source.local.ImageDatabase
import com.example.allinone.feature_unsplash.data.data_source.remote.ImageAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideUnsplashAPI(): ImageAPI {
        return Retrofit.Builder()
            .baseUrl(ImageAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideImageDatabase(app: Application): ImageDatabase {
        return Room.databaseBuilder(
            app,
            ImageDatabase::class.java,
            "imagesdb.db"
        ).build()
    }


}