package com.example.mvpeducationalexample.feature_list.data.repository

import com.example.mvpeducationalexample.core.utils.Resource
import com.example.mvpeducationalexample.feature_list.data.remote.PostApi
import com.example.mvpeducationalexample.feature_list.domain.model.Post
import com.example.mvpeducationalexample.feature_list.domain.repository.PostRepository
import kotlinx.coroutines.delay

class PostRepositoryImpl(
    private val api: PostApi
): PostRepository {

    override suspend fun fetchPosts(): Resource<List<Post>> {
        return try {
            delay(2500) // only for ProgressBar
            Resource.Success(api.fetchPosts())
        } catch (e: Exception) {
            Resource.Error(error = e.message)
        }
    }
}