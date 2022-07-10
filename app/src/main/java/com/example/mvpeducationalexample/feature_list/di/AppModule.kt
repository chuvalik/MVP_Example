package com.example.mvpeducationalexample.feature_list.di

import com.example.mvpeducationalexample.core.dispatcher.DispatcherProvider
import com.example.mvpeducationalexample.core.dispatcher.StandardDispatchers
import com.example.mvpeducationalexample.core.presenter.Presenter
import com.example.mvpeducationalexample.feature_list.presentation.posts.presenter.PostsPresenterImpl
import com.example.mvpeducationalexample.feature_list.presentation.posts.presenter.PostsView
import org.koin.dsl.module

val appModule = module {

    single<Presenter<PostsView>> {
        PostsPresenterImpl(
            repository = get(),
            dispatcher = get()
        )
    }

    single<DispatcherProvider> {
        StandardDispatchers()
    }
}