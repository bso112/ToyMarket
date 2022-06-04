package com.manta.topmarket.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun RecyclerView.bindSubmitList(itemList: List<Any>?) {
    (adapter as? ListAdapter<Any, *>)?.submitList(itemList)
}
