package com.swkang.ex.aacmvvmdagger.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swkang.ex.model.base.redux.AppStore
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import domain.common.message.HandledMessageAction
import domain.common.message.MessageState
import domain.common.message.ShowToastMessageState
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
abstract class BaseActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var appStore: AppStore
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        handleAppState()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private fun handleAppState() {
        compositeDisposable.add(
            appStore.stateListener()
                .flatMap { Observable.fromIterable(it.states.values) }
                .ofType(MessageState::class.java)
                .doOnNext { appStore.dispatch(HandledMessageAction) }
                .subscribe { handleMessageState(it) }
        )
    }

    private fun handleMessageState(state: MessageState) {
        when(state) {
            is ShowToastMessageState -> {

            }
        }
    }
}