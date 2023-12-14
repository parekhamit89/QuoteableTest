package com.demo.quoteabletest.api

import com.demo.quoteabletest.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotableService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int) : Response<QuoteList>

}