package com.manta.topmarket.util

sealed class NetWorkException(msg: String? = null) : Throwable(msg)
class InvalidResponseException(msg: String? = null) : NetWorkException(msg)
class HttpStatusException(msg: String? = null) : NetWorkException(msg)
class NullResponseException(msg : String? = null) : NetWorkException(msg)