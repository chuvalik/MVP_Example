package com.example.mvpeducationalexample.core.presenter

/**
 * While this interface is empty, it is used to clearly define any class that is representative
 * for a creating Presenter component of MVP architecture.
 */
interface Presenter<V: PresenterView> {
    var view: V?

    fun attachView(view: V)

    fun detachView()
}