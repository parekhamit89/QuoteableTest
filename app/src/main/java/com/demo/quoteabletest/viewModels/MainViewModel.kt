package com.demo.quoteabletest.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.quoteabletest.model.QuoteList
import com.demo.quoteabletest.repository.QuotableRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel(private val repository: QuotableRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(Random.nextInt(1,10))
        }
    }

    val quotes : LiveData<QuoteList>
        get() = repository.quotes
}