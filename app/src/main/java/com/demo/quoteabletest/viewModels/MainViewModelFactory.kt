package com.demo.quoteabletest.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.quoteabletest.repository.QuotableRepository

class MainViewModelFactory(private val repository: QuotableRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}