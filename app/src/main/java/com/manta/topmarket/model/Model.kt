package com.manta.topmarket.model


interface Model<T> {
    fun areItemsTheSame(other: T): Boolean
    fun areContentsTheSame(other: T): Boolean
    fun bindingVariableId() : Int
}