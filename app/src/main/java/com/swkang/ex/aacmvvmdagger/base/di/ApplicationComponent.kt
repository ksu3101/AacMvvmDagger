package com.swkang.ex.aacmvvmdagger.base.di

import android.content.Context
import com.swkang.ex.aacmvvmdagger.RestingPlacesApplication
import com.swkang.ex.aacmvvmdagger.view.restingplaces.di.RestingPlacesActivityModule
import com.swkang.ex.model.base.helper.MessageHelper
import com.swkang.ex.model.base.redux.AppStore
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 6/9/2020
 */
@Singleton
@Component(modules = [
    // common modules
    AndroidSupportInjectionModule::class,   // 이 모듈 추가 하지 않으면 빌드가 안됨 ㅡㅡ
    ApplicationModule::class,
    ReducerModule::class,

    // subcomponent modules
    RestingPlacesActivityModule::class
])
interface ApplicationComponent : AndroidInjector<RestingPlacesApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun appStore(): AppStore

    fun messageHelper(): MessageHelper

}
