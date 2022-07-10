package com.example.mvpeducationalexample.core.presenter

abstract class BasePresenter<V : PresenterView> : Presenter<V> {

    override var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}