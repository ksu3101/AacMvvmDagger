package domain.restingplaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.restingplaces.dto.RestingPlace

/**
 * @author kangsungwoo
 * @since 6/18/2020
 */
class RestingPlaceItemViewModel(
    private val restingPlace: RestingPlace
) : ViewModel() {

    private val _placeName = MutableLiveData(restingPlace.name)
    val placeName: LiveData<String>
        get() = _placeName

    fun getRestingPlace(): RestingPlace = restingPlace

}