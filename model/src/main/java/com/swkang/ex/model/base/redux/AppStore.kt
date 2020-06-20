package com.swkang.ex.model.base.redux

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
class AppStore(
    appState: AppState,
    reducer: Reducer<AppState>,
    middleWares: List<MiddleWare<AppState>>
) : Store<AppState> {
    private val stateEmitter: BehaviorSubject<AppState> = BehaviorSubject.create()
    private var state: AppState = appState
    private val dispatcher: Dispatcher

    init {
        val initDispatcher: Dispatcher = { action: Action ->
            state = reducer.reduce(getState(), action)
            stateEmitter.onNext(state)
        }
        dispatcher = middleWares.foldRight(initDispatcher) { nextMiddleware, prevDispatcher ->
            // return dispatcher function reference.
            nextMiddleware.create(this, prevDispatcher)
        }
    }

    override fun getState(): AppState = state

    override fun dispatch(action: Action) {
        dispatcher(action)
    }

    override fun stateListener(): Observable<AppState> =
        stateEmitter.hide().observeOn(AndroidSchedulers.mainThread())

}

data class AppState(
    val states: Map<Class<State>, State>
) : State {

}
