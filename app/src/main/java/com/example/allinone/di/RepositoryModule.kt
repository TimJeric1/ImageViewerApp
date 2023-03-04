package com.example.allinone.di

import com.example.allinone.feature_unsplash.data.repository.ImageRepositoryImpl
import com.example.allinone.feature_unsplash.domain.repository.ImageInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideImageRepository(imageRepositoryImpl: ImageRepositoryImpl): ImageInterface

}