package com.swkang.ex.aacmvvmdagger.view.restingplaces

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.swkang.ex.aacmvvmdagger.R
import com.swkang.ex.aacmvvmdagger.base.databinding.recyclerview.setUpRecyclerView
import domain.restingplaces.RestingPlaceItemViewModel
import domain.restingplaces.dto.RestingPlace

/**
 * @author kangsungwoo
 * @since 6/18/2020
 */

@BindingAdapter(value = ["restingPlaceItems", "onItemClicked"])
fun setUpRestingPlaceItems(rv: RecyclerView, items: List<RestingPlace>, onItemClicked: ((RestingPlace) -> Unit)) {
    setUpRecyclerView(
        rv,
        items.map { RestingPlaceItemViewModel(it) },
        RestingPlaceItemDiffCallback(),
        { onItemClicked(it.getRestingPlace()) }
    ) { R.layout.restingplaces_item }
}

private class RestingPlaceItemDiffCallback : DiffUtil.ItemCallback<RestingPlaceItemViewModel>() {
    override fun areItemsTheSame(oldItem: RestingPlaceItemViewModel, newItem: RestingPlaceItemViewModel): Boolean {
        return oldItem.getRestingPlace().id == newItem.getRestingPlace().id
    }

    override fun areContentsTheSame(oldItem: RestingPlaceItemViewModel, newItem: RestingPlaceItemViewModel): Boolean {
        return oldItem.getRestingPlace() == newItem.getRestingPlace()
    }
}
