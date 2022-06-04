package com.manta.topmarket.binding

import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.Placeholder
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("networkImage")
fun ImageView.setNetWorkImage(uri: String?) {
    Glide.with(context).load(uri).into(this)
}

@BindingAdapter("isVisible")
fun View.setIsVisible(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}


@BindingAdapter("isGone")
fun View.setIsGone(isGone: Boolean) {
    visibility = if (isGone) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

