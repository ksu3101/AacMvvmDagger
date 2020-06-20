package com.swkang.ex.aacmvvmdagger.base.di

import dagger.Module
import dagger.Provides
import domain.restingplaces.RestingPlacesReducer
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 6/19/2020
 */
@Module
object ReducerModule {

    @Singleton
    @Provides
    fun provideRestingPlacesReducer(): RestingPlacesReducer {
        return RestingPlacesReducer()
    }

}