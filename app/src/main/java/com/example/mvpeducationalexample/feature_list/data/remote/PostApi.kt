package com.example.mvpeducationalexample.feature_list.data.remote

import com.example.mvpeducationalexample.feature_list.domain.model.Post
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun fetchPosts(): List<Post>


    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}