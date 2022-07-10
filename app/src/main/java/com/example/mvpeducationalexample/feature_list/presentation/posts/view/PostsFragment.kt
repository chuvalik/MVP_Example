package com.example.mvpeducationalexample.feature_list.presentation.posts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.mvpeducationalexample.core.presenter.Presenter
import com.example.mvpeducationalexample.databinding.FragmentPostsBinding
import com.example.mvpeducationalexample.feature_list.domain.model.Post
import com.example.mvpeducationalexample.feature_list.presentation.posts.presenter.PostsView
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject


class PostsFragment : Fragment(), PostsView {

    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!

    private val postsPresenter by inject<Presenter<PostsView>>()
    private var adapter: PostsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postsPresenter.attachView(this@PostsFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    override fun onPause() {
        super.onPause()
        postsPresenter.detachView()
    }

    private fun setupAdapter() {
        adapter = PostsAdapter()
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showSuccess(data: List<Post>) {
        adapter?.submitList(data)
    }

    override fun startLoading() {
        binding.progressBar.isVisible = true
    }

    override fun endLoading() {
        binding.progressBar.isVisible = false
    }

    override fun showError(message: String) {
        Snackbar.make(
            requireView(),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}