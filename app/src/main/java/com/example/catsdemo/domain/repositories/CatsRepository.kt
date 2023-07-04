package com.example.catsdemo.domain.repositories

import com.example.catsdemo.domain.common.Result
import com.example.catsdemo.domain.entities.Cats

interface CatsRepository {

    suspend fun getCats(limit: Int, page: Int): Result<List<Cats>>

}