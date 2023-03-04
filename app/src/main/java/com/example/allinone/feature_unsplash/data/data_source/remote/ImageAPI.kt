package com.example.allinone.feature_unsplash.data.data_source.remote

import com.example.allinone.feature_unsplash.domain.model.ImagePost
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ImageAPI {

    companion object {
        const val BASE_URL = "https://api.unsplash.com"
        const val CLIENT_ID = "1JvX6H2JmlVx2lXS4S2Ff6NFLIHlFlQ6ijGb5ZKQwg8"
    }

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("/photos")
    suspend fun getPhotos(
        @Query ("page") page: Int = 1,
        @Query ("per_page") per_page: Int = 20,
        @Query ("order_by") order: String = "",
        @Query ("query") query: String = "",
        ) : Response<List<ImagePost>>

}