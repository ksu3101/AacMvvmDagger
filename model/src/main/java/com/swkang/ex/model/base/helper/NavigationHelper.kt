package com.swkang.ex.model.base.helper

import android.content.Intent
import com.swkang.ex.model.base.redux.State

/**
 * @author kangsungwoo
 * @since 6/23/2020
 */
interface NavigationHelper<S: State> {

    fun handle(state: S)

    /**
     * Activity에서 `onActivityResult()`시 호출 됨.
     * 필요한 경우 이 함수를 재정의 하고 리턴타입을 true로 변경 할 것.
     *
     * @return `true`일 경우 activity result를 사용 함.
     */
    @Deprecated("ActivityResultLauncher 정식 릴리즈 되면 마이그레이션 필요")
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        return false
    }

}