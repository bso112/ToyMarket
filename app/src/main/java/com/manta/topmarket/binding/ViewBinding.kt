package com.manta.topmarket.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("networkImage")
fun ImageView.setNetWorkImage(uri : String?){
    Glide.with(context).load(uri).into(this)
}