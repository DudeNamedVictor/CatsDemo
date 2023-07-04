package com.example.catsdemo.presentation.fragments.cats

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.catsdemo.domain.common.ResponceResult
import com.example.catsdemo.domain.entities.Cats
import com.example.catsdemo.domain.usecases.GetCatsUseCase

class CatsDataSource(private val getCatsUseCase: GetCatsUseCase) :
    PagingSource<Int, CatsRecyclerModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatsRecyclerModel> {
        try {
            val currentLoadingPageKey = params.key ?: 0
            val response = getCatsUseCase.invoke(STEP, STEP)
            val responseData = mutableListOf<CatsRecyclerModel>()

            when (response) {
                is ResponceResult.Success -> {
                    responseData.addAll(updateModel(response.data))
                }

                is ResponceResult.Error -> {
                    return LoadResult.Error(response.exception)
                }
            }

            val prevKey = if (currentLoadingPageKey == 0) null else currentLoadingPageKey - STEP

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(STEP)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }

    private fun updateModel(list: List<Cats>): List<CatsRecyclerModel> {
        val mappedList = mutableListOf<CatsRecyclerModel>()
        list.forEach {
            mappedList.add(
                CatsRecyclerModel(
                    id = it.id,
                    url = it.url
                )
            )
        }

        return mappedList
    }

    override fun getRefreshKey(state: PagingState<Int, CatsRecyclerModel>): Int {
        return 0
    }

    companion object {
        const val STEP = 20
    }

}