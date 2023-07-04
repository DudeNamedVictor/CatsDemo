package com.example.catsdemo.presentation.fragments.cats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.catsdemo.domain.usecases.GetCatsUseCase
import kotlinx.coroutines.launch

class CatsViewModel(
    private val getCatsUseCase: GetCatsUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            val test = getCatsUseCase.invoke(10, 10)
            test
        }

    }

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