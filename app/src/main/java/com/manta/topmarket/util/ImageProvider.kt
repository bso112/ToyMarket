package com.manta.topmarket.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class ImageProvider @Inject constructor() {

    fun loadImage(imageView: ImageView, uri: String) {
        Glide.with(imageView.context).load(uri).into(imageView)
    }
}