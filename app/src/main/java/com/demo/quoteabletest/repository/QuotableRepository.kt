package com.demo.quoteabletest.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demo.quoteabletest.api.QuotableService
import com.demo.quoteabletest.db.QuotableDatabase
import com.demo.quoteabletest.model.QuoteList
import com.demo.quoteabletest.utils.NetworkUtils

class QuotableRepository(private val quotableService: QuotableService,
                         private val quoteDatabase: QuotableDatabase,
                         private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int): QuoteList? {

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quotableService.getQuotes(page)
            if(result?.body() != null){
                quoteDatabase.quotableDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
                return result.body()
            }
        }
        else{
            val quotes = quoteDatabase.quotableDao().getQuotes()
            val quoteList = QuoteList(quotes.size,quotes.size+1,(quotes.size+1)/20,quotes, 1, 1)
            quotesLiveData.postValue(quoteList)
            return  quoteList
        }

        return null
    }
}
