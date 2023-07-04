package com.example.catsdemo.data.service

import com.example.catsdemo.data.api.Api
import com.example.catsdemo.data.models.response.CatsApiItems
import com.example.catsdemo.data.utils.Service
import retrofit2.Response

class NetworkModule(service: Service) {

    private var api: Api = service.getRetrofit().create(Api::class.java)

    suspend fun getCats(limit: Int, page: Int): Response<List<CatsApiItems>> =
        api.getCats(limit, page)

}