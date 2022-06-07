package com.manta.topmarket.ui.main

import android.animation.AnimatorSet
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearSnapHelper
import android.view.Window
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.manta.topmarket.R
import com.manta.topmarket.databinding.ActivityMainBinding
import com.manta.topmarket.databinding.ItemToyBoxBinding
import com.manta.topmarket.model.Product
import com.manta.topmarket.ui.detail.ProductDetailActivity
import com.manta.topmarket.util.AppListAdapter
import com.manta.topmarket.util.ImageProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val vm: MainViewModel by viewModels()

    @Inject
    lateinit var imageProvider: ImageProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        setUpTransition()
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.vm = vm

        binding.trendingToys.adapter = object : AppListAdapter<Product>(R.layout.item_toy_box) {
            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                super.onBindViewHolder(holder, position)
                val binding = holder.binding as ItemToyBoxBinding
                binding.root.setOnClickListener {
                    ProductDetailActivity.start(this@MainActivity, getItem(position), binding.productImg)
                }
            }
        }
        binding.recommendToys.adapter = AppListAdapter<Product>(R.layout.item_toy_row)
        LinearSnapHelper().attachToRecyclerView(binding.trendingToys)

    }

    private fun setUpTransition() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
    }
}