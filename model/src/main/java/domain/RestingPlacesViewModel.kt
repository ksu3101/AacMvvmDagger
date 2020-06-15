package domain

import com.swkang.ex.model.base.BaseViewModel

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
class RestingPlacesViewModel: BaseViewModel<RestingPlacesState>() {

    override fun render(state: RestingPlacesState): Boolean {
        return when (state) {
            else -> false
        }
    }

}