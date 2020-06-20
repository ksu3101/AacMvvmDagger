package com.swkang.ex.aacmvvmdagger.base.helper

import android.content.Context
import com.swkang.ex.model.base.helper.ResourceHelper

/**
 * @author kangsungwoo
 * @since 6/19/2020
 */
class ResourceHelperImpl(
    val context: Context
): ResourceHelper {

    override fun getString(strResId: Int): String = context.getString(strResId)

}