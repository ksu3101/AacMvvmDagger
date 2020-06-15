package com.swkang.ex.aacmvvmdagger

import androidx.multidex.MultiDex
import com.swkang.ex.aacmvvmdagger.base.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * @author kangsungwoo
 * @since 6/9/2020
 */
class RestingPlacesApplication: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }

}