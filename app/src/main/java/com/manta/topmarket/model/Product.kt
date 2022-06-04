package com.manta.topmarket.model

import com.manta.topmarket.BR

data class Product(
    val id: Int,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String
) : Model<Product> {
    override fun areItemsTheSame(other: Product): Boolean {
        return id == other.id
    }

    override fun areContentsTheSame(other: Product): Boolean {
        return this == other
    }

    override fun bindingVariableId(): Int = BR.product


}