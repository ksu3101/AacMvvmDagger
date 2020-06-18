package domain.restingplaces

import com.swkang.ex.model.base.redux.State

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */

sealed class RestingPlacesState: State

object InitializedState: RestingPlacesState()