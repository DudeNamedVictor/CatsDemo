package com.example.catsdemo.data.api

import com.example.catsdemo.data.models.response.CatsApiItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("images/search?")
    suspend fun getCats(@Query("limit") offset: Int, @Query("page") page: Int): Response<List<CatsApiItems>>

}