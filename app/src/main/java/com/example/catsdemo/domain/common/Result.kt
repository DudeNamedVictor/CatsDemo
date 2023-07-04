package com.example.catsdemo.domain.common

sealed class Result<out R> {

    class Success<T>(val data: T): Result<T>()

    class Error(val exception: Exception): Result<Nothing>()

}