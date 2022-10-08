package com.android.dictionaryapp.utils

sealed class ResponseState<out T> {
   object Loading : ResponseState<Nothing>()
   data class Success<T>(val data: T) : ResponseState<T>()
   data class Fail(val message: String, val code: Int) : ResponseState<Nothing>()
}
