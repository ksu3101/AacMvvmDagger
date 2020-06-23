package domain.restingplaces

import android.content.Context
import android.content.Intent
import com.swkang.ex.model.base.helper.NavigationHelper
import io.reactivex.Observable

/**
 * @author kangsungwoo
 * @since 6/23/2020
 */
interface RestingPlacesNavigationHelper: NavigationHelper<RestingPlacesState> {

    fun startTestActivityForResult(): Observable<String>

}