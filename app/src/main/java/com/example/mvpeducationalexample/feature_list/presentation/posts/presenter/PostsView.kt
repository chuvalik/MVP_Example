package com.example.mvpeducationalexample.feature_list.presentation.posts.presenter

import com.example.mvpeducationalexample.core.presenter.PresenterView
import com.example.mvpeducationalexample.feature_list.domain.model.Post

interface PostsView : PresenterView {
    fun showSuccess(data: List<Post>)
    fun startLoading()
    fun endLoading()
    fun showError(message: String)
}