package com.swkang.ex.aacmvvmdagger.view.restingplaces

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.swkang.ex.aacmvvmdagger.R
import com.swkang.ex.aacmvvmdagger.base.BaseFragment
import com.swkang.ex.model.base.BaseViewModel
import domain.RestingPlacesState
import domain.RestingPlacesViewModel
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
class RestingPlacesFragment: BaseFragment<RestingPlacesState>() {

    @Inject lateinit var vmFactory: ViewModelProvider.Factory
    private val vm: RestingPlacesViewModel by viewModels { vmFactory }

    override fun createViewModel(): BaseViewModel<RestingPlacesState> = vm

    override fun getLayoutId(): Int = R.layout.restingplaces_fragment


}