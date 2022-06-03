package com.manta.topmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.manta.topmarket.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private val binding : ActivityProductDetailBinding by lazy{
        DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding


    }
}