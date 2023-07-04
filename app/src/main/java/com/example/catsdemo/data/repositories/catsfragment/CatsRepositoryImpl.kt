package com.example.catsdemo.data.repositories.catsfragment

import com.example.catsdemo.data.mappers.CatsApiResponseMapper
import com.example.catsdemo.data.service.NetworkModule
import com.example.catsdemo.domain.entities.Cats
import com.example.catsdemo.domain.repositories.CatsRepository
import com.example.catsdemo.domain.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatsRepositoryImpl(
    private val networkModule: NetworkModule,
    private val catsApiResponseMapper: CatsApiResponseMapper
) : CatsRepository {

    override suspend fun getCats(limit: Int, page: Int): Result<List<Cats>> =
        withContext(Dispatchers.IO) {
            try {
                val response = networkModule.getCats(limit, page)
                if (response.isSuccessful) {
                    return@withContext Result.Success(
                        catsApiResponseMapper.toCatsList(response.body() ?: emptyList())
                    )
                } else {
                    return@withContext Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }

}