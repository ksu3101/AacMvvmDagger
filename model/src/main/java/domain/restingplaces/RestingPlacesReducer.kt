package domain.restingplaces

import com.swkang.ex.model.base.redux.Action
import com.swkang.ex.model.base.redux.Reducer

/**
 * @author kangsungwoo
 * @since 6/18/2020
 */
class RestingPlacesReducer : Reducer<RestingPlacesState> {
    override val initializeState: RestingPlacesState = InitializedState

    override fun reduce(oldState: RestingPlacesState, resultAction: Action): RestingPlacesState {
        return when (resultAction) {

            else -> oldState
        }
    }

}