package domain.restingplaces

import com.swkang.ex.model.base.redux.Action
import com.swkang.ex.model.base.redux.Reducer

/**
 * @author kangsungwoo
 * @since 6/18/2020
 */
class RestingPlacesReducer(
    override val initializeState: RestingPlacesState = InitializedState
) : Reducer<RestingPlacesState> {

    override fun reduce(oldState: RestingPlacesState, resultAction: Action): RestingPlacesState {
        return when (resultAction) {

            else -> oldState
        }
    }

}