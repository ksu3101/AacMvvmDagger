package com.swkang.ex.aacmvvmdagger.view.restingplaces.di

import com.swkang.ex.aacmvvmdagger.view.restingplaces.RestingPlacesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
@Module
abstract class RestingPlacesActivityModule {

    @ContributesAndroidInjector(modules = [RestingPlacesFragmentModule::class])
    abstract fun restingPlacesActivity(): RestingPlacesActivity

}