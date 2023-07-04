package com.example.catsdemo.domain.common

sealed class Result<R> {

    class Success<T>(val data: T): Result<T>()

    class Error(val exception: Exception): Result<Nothing>()

}