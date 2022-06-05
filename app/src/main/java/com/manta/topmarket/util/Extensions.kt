package com.manta.topmarket.util


fun <T> List<T>?.toSafe() : List<T> {
    return this ?: emptyList()
}

fun Boolean?.toSafe() : Boolean {
    return this ?: false
}

fun Int?.toSafe() : Int{
    return this ?: 0
}

fun String?.toSafe() : String{
    return this ?: ""
}