package com.example.catsdemo.domain.repositories

import com.example.catsdemo.domain.common.ResponceResult
import com.example.catsdemo.domain.entities.Cats

interface CatsRepository {

    suspend fun getCats(limit: Int, page: Int): ResponceResult<List<Cats>>

}