package com.swkang.ex.aacmvvmdagger.base.databinding.recyclerview

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * @author kangsungwoo
 * @since 6/18/2020
 */

fun <E> setUpRecyclerView(
    rv: RecyclerView,
    items: List<E>,
    diffCallback: DiffUtil.ItemCallback<E>,
    onItemClickedListener: ((E) -> Unit)? = null,
    viewTypeProvider: ViewTypeProvider<E>? = null
) {
    val adapter = RecyclerViewModelAdapter(
        diffCallback, viewTypeProvider, onItemClickedListener
    )
    rv.adapter = adapter
    adapter.submitList(items)
}