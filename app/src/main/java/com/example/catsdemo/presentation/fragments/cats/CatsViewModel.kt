package com.example.catsdemo.presentation.fragments.cats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.catsdemo.domain.usecases.GetCatsUseCase
import kotlinx.coroutines.launch

class CatsViewModel(
    private val getCatsUseCase: GetCatsUseCase
) : ViewModel() {

    var catsListMLD = MutableLiveData<PagingData<CatsRecyclerModel>>()

    init {
        viewModelScope.launch {
            catsListMLD = getCats() as MutableLiveData<PagingData<CatsRecyclerModel>>
        }
    }

    private fun getCats() =
        Pager(config = PagingConfig(
            pageSize = CatsDataSource.STEP,
            enablePlaceholders = false
        ), pagingSourceFactory = {
            CatsDataSource(getCatsUseCase)
        }).liveData

    class CatsViewModelFactory(
        private val getCatsUseCase: GetCatsUseCase
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CatsViewModel(
                getCatsUseCase
            ) as T
        }
    }

}