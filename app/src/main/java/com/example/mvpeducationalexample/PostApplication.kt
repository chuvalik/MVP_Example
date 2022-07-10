package com.example.mvpeducationalexample

import android.app.Application
import com.example.mvpeducationalexample.feature_list.di.appModule
import com.example.mvpeducationalexample.feature_list.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PostApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PostApplication)
            modules(
                appModule,
                dataModule
            )
        }
    }
}