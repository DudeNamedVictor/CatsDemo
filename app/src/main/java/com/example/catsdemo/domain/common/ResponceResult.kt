package com.example.catsdemo.domain.common

sealed class ResponceResult<out R> {

    class Success<T>(val data: T) : ResponceResult<T>()

    class Error(val exception: Exception) : ResponceResult<Nothing>()

}