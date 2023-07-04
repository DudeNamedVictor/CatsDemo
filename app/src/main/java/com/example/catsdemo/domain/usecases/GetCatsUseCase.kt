package com.example.catsdemo.domain.usecases

import com.example.catsdemo.domain.common.ResponceResult
import com.example.catsdemo.domain.entities.Cats
import com.example.catsdemo.domain.repositories.CatsRepository

class GetCatsUseCase(private val catsRepository: CatsRepository) {

    suspend fun invoke(limit: Int, page: Int): ResponceResult<List<Cats>> =
        catsRepository.getCats(limit, page)

}