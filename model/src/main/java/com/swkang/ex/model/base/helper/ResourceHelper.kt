package com.swkang.ex.model.base.helper

import androidx.annotation.StringRes

/**
 * @author kangsungwoo
 * @since 6/19/2020
 */
interface ResourceHelper {

    fun getString(@StringRes strResId: Int): String

}