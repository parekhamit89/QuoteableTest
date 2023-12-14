package com.demo.quoteabletest.viewModels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.demo.quoteabletest.getOrAwaitValue
import com.demo.quoteabletest.model.QuoteList
import com.demo.quoteabletest.repository.QuotableRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: QuotableRepository

    private var testDispatcher = StandardTestDispatcher()


    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)

    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetQuotes_empty() = runTest {

        Mockito.`when`(repository.getQuotes(1)).thenReturn(QuoteList(1, 0, 1, emptyList(), 0, 1))

        var systemUndersTest = MainViewModel(repository)
        var result = systemUndersTest.quotes.getOrAwaitValue()
        //To complete all the coroutine
        testDispatcher.scheduler.advanceUntilIdle()


        Assert.assertEquals(0, result.results.size)
    }
}

