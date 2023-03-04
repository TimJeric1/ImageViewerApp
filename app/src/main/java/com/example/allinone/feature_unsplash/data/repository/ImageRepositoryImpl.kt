package com.example.allinone.feature_unsplash.data.repository

import com.example.allinone.feature_unsplash.Util.Resource
import com.example.allinone.feature_unsplash.data.data_source.local.ImageDao
import com.example.allinone.feature_unsplash.data.data_source.local.ImageDatabase
import com.example.allinone.feature_unsplash.data.data_source.remote.ImageAPI
import com.example.allinone.feature_unsplash.domain.model.ImagePost
import com.example.allinone.feature_unsplash.domain.repository.ImageInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepositoryImpl @Inject constructor(
    private val imageAPI: ImageAPI,
    private val db: ImageDatabase
): ImageInterface {

    val dao = db.dao


    override suspend fun getImagePosts(
        page: Int,
        fetchFromRemote: Boolean,
        query: String,
        order: String
    ): Flow<Resource<List<ImagePost>>> {
            return flow {
            emit(Resource.Loading(true))
            val localImagePosts = dao.GetImagePosts()
            emit(Resource.Success(data = localImagePosts))

            val isDbEmpty = localImagePosts.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if(shouldJustLoadFromCache){
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteImagePosts = try {
                val response = imageAPI.getPhotos(
                    page = page,
                    per_page = 20,
                    order = order,
                    query = query
                )
                response.body()

            } catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error(e.message.toString()))
                null
            } catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error(e.message.toString()))
                null
            }

            remoteImagePosts?.let { imagePosts ->
                dao.ClearImagePosts()
                dao.InsertImagePosts(imagePosts)
                emit(Resource.Success(
                    data = dao.GetImagePosts()
                ))
                emit(Resource.Loading(false))
            }


        }



    }





} 
