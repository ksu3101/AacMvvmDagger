package com.swkang.ex.aacmvvmdagger.base.di

import android.content.Context
import com.swkang.ex.aacmvvmdagger.base.helper.MessageHelperImpl
import com.swkang.ex.aacmvvmdagger.base.helper.ResourceHelperImpl
import com.swkang.ex.model.base.helper.MessageHelper
import com.swkang.ex.model.base.helper.ResourceHelper
import com.swkang.ex.model.base.redux.*
import dagger.Module
import dagger.Provides
import domain.restingplaces.RestingPlacesReducer
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 6/14/2020
 */
@Module
object ApplicationModule {

    @Singleton
    @Provides
    fun provideAppState(): AppState {
        return AppState(mapOf())
    }

    @Singleton
    @Provides
    fun provideAppReducer(
        appState: AppState,
        restingPlacesReducer: RestingPlacesReducer
    ): AppReducer {
        return AppReducer(
            appState,
            listOf(
                restingPlacesReducer
            )
        )
    }

    @Singleton
    @Provides
    fun provideMiddlewares(): @JvmSuppressWildcards List<MiddleWare<AppState>> {
        return listOf(
            ActionProcessorMiddleware(
                CombinedActionProcessor(
                    listOf()
                )
            )
        )
    }

    @Singleton
    @Provides
    fun provideAppStore(
        appState: AppState,
        reducers: AppReducer,
        middlewares: @JvmSuppressWildcards List<MiddleWare<AppState>>
    ): AppStore {
        return AppStore(appState, reducers, middlewares)
    }

    @Singleton
    @Provides
    fun provideMessageHelper(context: Context): MessageHelper {
        return MessageHelperImpl(context)
    }

    @Singleton
    @Provides
    fun provideResourceHelper(context: Context): ResourceHelper {
        return ResourceHelperImpl(context)
    }

}