package com.demo.quoteabletest

import android.app.Application
import com.demo.quoteabletest.api.QuotableService
import com.demo.quoteabletest.api.RetrofitHelper
import com.demo.quoteabletest.db.QuotableDatabase
import com.demo.quoteabletest.repository.QuotableRepository

class QuotableApp: Application() {
    lateinit var quotableRepository: QuotableRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuotableService::class.java)
        val database = QuotableDatabase.getDatabase(applicationContext)
        quotableRepository = QuotableRepository(quoteService, database, applicationContext)
    }
}