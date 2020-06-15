package com.swkang.ex.aacmvvmdagger.view.restingplaces.di

import com.swkang.ex.aacmvvmdagger.base.ViewModelBuilder
import com.swkang.ex.aacmvvmdagger.view.restingplaces.RestingPlacesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
@Module
abstract class RestingPlacesFragmentModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun restingPlacesFragment(): RestingPlacesFragment

}