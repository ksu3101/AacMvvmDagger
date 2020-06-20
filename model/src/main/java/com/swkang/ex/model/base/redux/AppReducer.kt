package com.swkang.ex.model.base.redux

/**
 * @author kangsungwoo
 * @since 6/19/2020
 */
class AppReducer(
    appState: AppState,
    reducers: List<Reducer<*>>
): Reducer<AppState> {
    override val initializeState: AppState = appState

    override fun reduce(oldState: AppState, resultAction: Action): AppState {
        return oldState // FIXME
    }

}