package com.swkang.ex.aacmvvmdagger.base.databinding.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swkang.ex.aacmvvmdagger.BR

typealias ViewTypeProvider<T> = ((itemTypeByPosition: T) -> /* LayoutRes */ Int)

/**
 * @author kangsungwoo
 * @since 6/18/2020
 */
class RecyclerViewModelAdapter<E>(
    diffCallback: DiffUtil.ItemCallback<E>,
    private val viewTypeProvider: ViewTypeProvider<E>? = null,
    private val onItemClickedListener: ((E) -> Unit)? = null
) : ListAdapter<E, RecyclerViewModelAdapter.DataBindingViewHolder<E>>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<E> {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), viewType, parent, false)
        val viewHolder = DataBindingViewHolder<E>(binding)
        onItemClickedListener?.let {
            binding.root.setOnClickListener { it(getItem(viewHolder.adapterPosition)) }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holderDataBinding: DataBindingViewHolder<E>, position: Int) {
        holderDataBinding.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if (viewTypeProvider == null) 0
        else viewTypeProvider!!(getItem(position))
    }

    class DataBindingViewHolder<E>(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: E) {
            binding.setVariable(BR.vm, item)
            binding.executePendingBindings()
        }
    }
}
