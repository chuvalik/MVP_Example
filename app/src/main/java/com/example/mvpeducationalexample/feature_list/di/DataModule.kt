package com.example.mvpeducationalexample.feature_list.di

import com.example.mvpeducationalexample.feature_list.data.remote.PostApi
import com.example.mvpeducationalexample.feature_list.data.repository.PostRepositoryImpl
import com.example.mvpeducationalexample.feature_list.domain.repository.PostRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<PostApi> {
        Retrofit.Builder()
            .baseUrl(PostApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)

    }

    single<PostRepository> {
        PostRepositoryImpl(api = get())
    }
}