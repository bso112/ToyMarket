package com.manta.topmarket.ui.detail

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.manta.topmarket.R
import com.manta.topmarket.databinding.ActivityProductDetailBinding
import com.manta.topmarket.model.Product
import com.manta.topmarket.ui.detail.ProductDetailActivity.Companion.EXTRA_PRODUCT

class ProductDetailActivity : AppCompatActivity() {

    private val binding: ActivityProductDetailBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setUpTransition()
        super.onCreate(savedInstanceState)
        binding.product = intent.getSerializableExtra(EXTRA_PRODUCT) as Product
    }

    private fun setUpTransition(){
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        ViewCompat.setTransitionName(
            findViewById(android.R.id.content),
            getString(R.string.shared_element_product_img)
        )
        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 300L
            pathMotion = MaterialArcMotion()
            endContainerColor = Color.WHITE
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 300L
            pathMotion = MaterialArcMotion()
            startContainerColor = Color.WHITE
        }
    }

    companion object {
        private const val EXTRA_PRODUCT = "EXTRA_PRODUCT"

        fun start(srcActivity: Activity, product : Product, startView: View) {
            val intent = Intent(srcActivity, ProductDetailActivity::class.java).apply{
                putExtra(EXTRA_PRODUCT, product)
            }
            val options = ActivityOptions.makeSceneTransitionAnimation(
                srcActivity,
                startView,
                srcActivity.getString(R.string.shared_element_product_img) // The transition name to be matched in Activity B.
            )
            ActivityCompat.startActivity(srcActivity, intent, options.toBundle())

        }
    }
}