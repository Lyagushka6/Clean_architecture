package com.example.clean_architecture_month_7.domain.utils

sealed class Resource<T>(
    val data: T? = null,
    val message: T? = null,
) {

    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>()
    class Error<T>(message: String?, data: T? = null) : Resource<T>()
}