package com.swkang.ex.model.base

import androidx.lifecycle.ViewModel
import com.swkang.ex.model.base.redux.State
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
abstract class BaseViewModel<S: State> : ViewModel(), RxDisposer {
    private lateinit var compositeDisposable: CompositeDisposable

    abstract fun render(state: S): Boolean

    override fun addDisposer(disposable: Disposable) {
        if (!::compositeDisposable.isInitialized) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable.add(disposable)
    }

    override fun dispose() {
        if (::compositeDisposable.isInitialized) {
            compositeDisposable.dispose()
        }
    }
}