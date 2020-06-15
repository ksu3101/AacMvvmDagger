package com.swkang.ex.model.base.redux

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject

/**
 * TODO : implement this class (Store)
 *
 * @author kangsungwoo
 * @since 6/15/2020
 */
class AppStore
    //: Store<AppState>
{
    private val stateEmitter: BehaviorSubject<State> = BehaviorSubject.create()

    fun getStateListener(): Observable<State> =
        stateEmitter.hide().observeOn(AndroidSchedulers.mainThread())

}