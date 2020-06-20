package com.swkang.ex.aacmvvmdagger.base.helper

import android.content.Context
import android.widget.Toast
import com.swkang.ex.model.base.helper.MessageHelper

/**
 * @author kangsungwoo
 * @since 6/19/2020
 */
class MessageHelperImpl(
    val context: Context
): MessageHelper {

    override fun showToast(msgResId: Int) {
        Toast.makeText(context, msgResId, Toast.LENGTH_SHORT).show()
    }

}