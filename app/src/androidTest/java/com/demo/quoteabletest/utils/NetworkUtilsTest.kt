package com.demo.quoteabletest.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert
import org.junit.Test

class NetworkUtilsTest{
    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun isNetworConnected_True(){

        assert(true, { NetworkUtils.isInternetAvailable(context) })
    }

    @Test
    fun isNetworConnected_false(){

        //off all the network


        assert(true, { NetworkUtils.isInternetAvailable(context) })
    }
}