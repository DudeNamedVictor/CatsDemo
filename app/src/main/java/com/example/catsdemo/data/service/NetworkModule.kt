package com.example.catsdemo.data.service

import com.example.catsdemo.data.api.Api
import com.example.catsdemo.data.models.response.CatsModel
import com.example.catsdemo.data.utils.Service

class NetworkModule(service: Service) {

    private var api: Api = service.getRetrofit().create(Api::class.java)

    suspend fun getCats(limit: Int, page: Int): List<CatsModel> = api.getCats(limit, page)

}