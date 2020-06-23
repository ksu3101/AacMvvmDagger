package com.swkang.ex.aacmvvmdagger.view.restingplaces

import android.app.Activity
import android.content.Intent
import com.swkang.ex.common.REQUESTCODE_TEST_ACTIVITY
import com.swkang.ex.common.RESULT_INTENT_KEY_TSTRING
import domain.restingplaces.RestingPlacesNavigationHelper
import domain.restingplaces.RestingPlacesState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 6/23/2020
 */
class RestingPlacesNavigationHelperImpl @Inject constructor(
    val activity: RestingPlacesActivity
): RestingPlacesNavigationHelper {
    private lateinit var activityResultListener: PublishSubject<String>

    override fun handle(state: RestingPlacesState) {
        when (state) {
            // TODO
        }
    }

    override fun startTestActivityForResult(): Observable<String> {
        if (!::activityResultListener.isInitialized) {
            activityResultListener = PublishSubject.create()
        }
        activity.startActivityForResult(Intent(), REQUESTCODE_TEST_ACTIVITY)
        return activityResultListener.hide().observeOn(AndroidSchedulers.mainThread())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        if (requestCode != REQUESTCODE_TEST_ACTIVITY) return false
        when (resultCode) {
            Activity.RESULT_OK -> {
                if (data == null) throw NullPointerException("data[Intent] may not be Null.")
                val testString = data.getStringExtra(RESULT_INTENT_KEY_TSTRING)
                activityResultListener.onNext(testString)
            }
        }
        return true
    }

}