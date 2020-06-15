package com.swkang.ex.aacmvvmdagger.view.restingplaces.di

import com.swkang.ex.aacmvvmdagger.view.restingplaces.RestingPlacesActivity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
@Subcomponent(modules = [ ])
interface RestingPlacesActivityComponent: AndroidInjector<RestingPlacesActivity> {
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<RestingPlacesActivity>
}

@Module(subcomponents = [ RestingPlacesActivityComponent::class ])
abstract class RestingPlacesActivityModule {
    @Binds
    @IntoMap
    @ClassKey(RestingPlacesActivity::class)
    abstract fun bindRestingPlacesActivityFactory(
        factory: RestingPlacesActivityComponent.Factory
    ): AndroidInjector.Factory<*>
}