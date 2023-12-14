package com.demo.quoteabletest.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.demo.quoteabletest.model.QuoteList
import com.demo.quoteabletest.model.Result
import kotlinx.coroutines.runBlocking
import com.demo.quoteabletest.model.Result as Quote

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuotabnleDaoTest {

    lateinit var quotableDatabase: QuotableDatabase
    lateinit var quotableDao: QuotableDao

    @Before
    fun setUp() {
        quotableDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuotableDatabase::class.java
        ).allowMainThreadQueries().build()

        quotableDao = quotableDatabase.quotableDao()

    }

    @After
    fun tearDown() {
        quotableDatabase.close()
    }


    @Test
    fun insertQuote_getQuotes() = runBlocking {
        val addQuotes = arrayListOf<Result>()
        addQuotes.add(
            Quote(
                "asdf",
                "Amit",
                "amity",
                "Content is Original,though thats a inspired thought from other contents",
                "11122023",
                "11122023",
                75
            )
        )
        addQuotes.add(
            Quote(
                "pqr",
                "Amit",
                "amity",
                "new Content is Original,though thats a inspired thought from other contents",
                "11122023",
                "11122023",
                75
            )
        )

        quotableDao.addQuotes(addQuotes)
        var retrivedQuotes = quotableDao.getQuotes()

        Assert.assertEquals(2, retrivedQuotes.size)
    }

    @Test
    fun insertQuote_withSameId() = runBlocking{
        val addQuotes = arrayListOf<Result>()
        addQuotes.add(
            Quote(
                "asdf",
                "Amit",
                "amity",
                "Content is Original,though thats a inspired thought from other contents",
                "11122023",
                "11122023",
                75
            )
        )
        addQuotes.add(
            Quote(
                "asdf",
                "Amit",
                "amity",
                "Content is Original,though thats a inspired thought from other contents",
                "11122023",
                "11122023",
                75
            )
        )

        quotableDao.addQuotes(addQuotes)
        var retrivedQuotes = quotableDao.getQuotes()
        Assert.assertEquals(1, retrivedQuotes.size)
    }

}