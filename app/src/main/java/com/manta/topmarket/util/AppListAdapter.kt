package com.manta.topmarket.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.manta.topmarket.model.Model

fun <T : Model<T>> createDiffUtil(): DiffUtil.ItemCallback<T> {
    return object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.areItemsTheSame(newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.areContentsTheSame(newItem)
        }
    }
}

abstract class AppListAdapter<T : Model<T>, B : ViewDataBinding>(
    private val layoutId: Int,
) : ListAdapter<T, AppListAdapter.ViewHolder<B>>(createDiffUtil()) {

    class ViewHolder<B : ViewDataBinding>(val binding: B) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> {
        val binding: B =
            DataBindingUtil.inflate<B>(LayoutInflater.from(parent.context), layoutId, parent, false)
                .apply {
                    lifecycleOwner = parent.findViewTreeLifecycleOwner()
                }
        return ViewHolder(binding)
    }

}