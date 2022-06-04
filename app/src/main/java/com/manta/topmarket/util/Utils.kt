package com.manta.topmarket.util

import android.content.Context
import android.util.TypedValue
import androidx.recyclerview.widget.DiffUtil
import com.manta.topmarket.model.Model


fun dpToPx(context: Context, dp: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        context.resources.displayMetrics
    ).toInt()
}

