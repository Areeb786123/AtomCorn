package com.areeb.atomcorn.utils

sealed class Resource<T>(val data: T? = null, message: String? = null) {
    class SUCCESS<T>(data: T) : Resource<T>(data = data)
    class ERROR<T>(error: String) : Resource<T>(message = error)
}