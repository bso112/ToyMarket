package com.manta.topmarket.binding

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.manta.topmarket.util.toSafe

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

@BindingAdapter("fadeInText")
fun TextView.setFadeInText(text: String?){
    this.text = text.toSafe()
    val slideDown = ObjectAnimator.ofFloat(this, "TranslationY", -30f, 0f).apply {
        duration = 1000
    }
    val fadeIn = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f).apply {
        duration = 2000
    }
    AnimatorSet().apply {
        play(slideDown).with(fadeIn)
        start()
    }
}