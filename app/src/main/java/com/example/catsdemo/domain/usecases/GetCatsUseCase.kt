package com.example.catsdemo.domain.usecases

import com.example.catsdemo.domain.repositories.CatsRepository

class GetCatsUseCase(private val catsRepository: CatsRepository) {

    suspend fun invoke(limit: Int, page: Int) = catsRepository.getCats(limit, page)

}