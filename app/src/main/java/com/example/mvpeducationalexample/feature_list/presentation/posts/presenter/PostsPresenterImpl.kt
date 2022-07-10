package com.example.mvpeducationalexample.feature_list.presentation.posts.presenter

import com.example.mvpeducationalexample.core.dispatcher.DispatcherProvider
import com.example.mvpeducationalexample.core.presenter.BasePresenter
import com.example.mvpeducationalexample.core.utils.Resource
import com.example.mvpeducationalexample.feature_list.domain.repository.PostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostsPresenterImpl(
    private val repository: PostRepository,
    private val dispatcher: DispatcherProvider
) : BasePresenter<PostsView>() {

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        CoroutineScope(dispatcher.main).launch {
            view?.startLoading()

            val event = withContext(dispatcher.io) {
                repository.fetchPosts()
            }

            when (event) {
                is Resource.Success -> view?.showSuccess(event.data ?: emptyList())
                is Resource.Error -> view?.showError(event.error ?: "error")
                else -> Unit
            }

            view?.endLoading()
        }
    }
}