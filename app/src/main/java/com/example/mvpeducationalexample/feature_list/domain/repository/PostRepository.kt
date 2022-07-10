package com.example.mvpeducationalexample.feature_list.domain.repository

import com.example.mvpeducationalexample.core.utils.Resource
import com.example.mvpeducationalexample.feature_list.domain.model.Post

interface PostRepository {

    suspend fun fetchPosts(): Resource<List<Post>>
}