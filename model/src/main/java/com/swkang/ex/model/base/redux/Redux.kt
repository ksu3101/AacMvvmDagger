package com.swkang.ex.model.base.redux

import io.reactivex.Observable


interface Action

interface State

interface Reducer<S : State> {
    val initializeState: S

    fun reduce(oldState: S, resultAction: Action): S
}

typealias Dispatcher = (Action) -> Unit

interface Store<S: State> {
    fun getState(): S

    fun dispatch(action: Action)

    fun stateListener(): Observable<S>
}

interface MiddleWare<S: State> {
    fun create(store: Store<S>, next: Dispatcher): Dispatcher
}

inline fun <reified S: State> Observable<S>.isStateType(): Observable<S> = ofType<S>(S::class.java)