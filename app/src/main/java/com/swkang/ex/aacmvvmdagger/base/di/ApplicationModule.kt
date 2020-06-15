package com.swkang.ex.aacmvvmdagger.base.di

import com.swkang.ex.model.base.redux.AppStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 6/14/2020
 */
@Module
object ApplicationModule {

    @Singleton
    @Provides
    fun provideAppStore(): AppStore {
        return AppStore()
    }

}