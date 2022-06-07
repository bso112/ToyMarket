package com.manta.topmarket.model

import java.io.Serializable


interface Model<T> : Serializable {
    fun areItemsTheSame(other: T): Boolean
    fun areContentsTheSame(other: T): Boolean
    fun bindingVariableId(): Int
}