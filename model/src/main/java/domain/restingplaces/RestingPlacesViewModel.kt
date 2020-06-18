package domain.restingplaces

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swkang.ex.model.base.BaseViewModel
import domain.restingplaces.dto.RestingPlace
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
class RestingPlacesViewModel @Inject constructor(
    // TODO
) : BaseViewModel<RestingPlacesState>() {

    private val _restingPlaceItems = MutableLiveData<List<RestingPlace>>().apply { value = emptyList() }
    val restingPlaceItems: LiveData<List<RestingPlace>>
        get() = _restingPlaceItems

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val onRestingPlaceItemClicked: ((RestingPlace) -> Unit) = {
        Log.d("RestingPlacesViewModel", "/// onItemClicked = $it")
    }

    init {
        // FIXME : for TEST
        _restingPlaceItems.value = listOf(
            RestingPlace(100, "AA AAA"),
            RestingPlace(101, "BBB"),
            RestingPlace(102, "CCCC CC CCCC C")
        )

        Log.e("RestingPlacesViewModel", "Initlaized ViewModel // _restingPlaceItems.size() = ${_restingPlaceItems.value!!.size}")
    }

    override fun render(state: RestingPlacesState): Boolean {
        return when (state) {
            is InitializedState -> {
                _restingPlaceItems.value = emptyList()
                _isLoading.value = false
                true
            }

            else -> false
        }
    }

}
