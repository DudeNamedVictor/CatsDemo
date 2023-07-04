package com.example.catsdemo.presentation.fragments.cats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.catsdemo.domain.usecases.GetCatsUseCase
import com.example.catsdemo.presentation.MainApplication
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatsViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var catsUseCase: GetCatsUseCase

    init {
        getApplication<MainApplication>()
            .appComponent
            .inject(this)

        viewModelScope.launch {
            val test =  catsUseCase.invoke(10, 10)
            test
        }

    }

}