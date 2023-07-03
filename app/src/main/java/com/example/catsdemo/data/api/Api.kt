package com.example.catsdemo.data.api

import com.example.catsdemo.data.models.response.CatsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("images/search?")
    suspend fun getCats(@Query("limit") offset: Int, @Query("page") page: Int): List<CatsModel>

}