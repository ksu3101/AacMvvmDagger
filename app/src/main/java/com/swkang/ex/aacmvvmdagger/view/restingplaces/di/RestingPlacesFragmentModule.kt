package com.swkang.ex.aacmvvmdagger.view.restingplaces.di

import androidx.lifecycle.ViewModel
import com.swkang.ex.aacmvvmdagger.base.di.factory.ViewModelBuilder
import com.swkang.ex.aacmvvmdagger.base.di.factory.ViewModelKey
import com.swkang.ex.aacmvvmdagger.view.restingplaces.RestingPlacesFragment
import com.swkang.ex.aacmvvmdagger.view.restingplaces.RestingPlacesNavigationHelperImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import domain.restingplaces.RestingPlacesNavigationHelper
import domain.restingplaces.RestingPlacesViewModel

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
@Module
abstract class RestingPlacesFragmentModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun restingPlacesFragment(): RestingPlacesFragment

    @Binds
    @IntoMap
    @ViewModelKey(RestingPlacesViewModel::class)
    abstract fun bindViewModel(viewModel: RestingPlacesViewModel): ViewModel

    @Binds
    abstract fun bindNavigationHelper(navigationHelper: RestingPlacesNavigationHelperImpl): RestingPlacesNavigationHelper

}

