package com.demo.quoteabletest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.quoteabletest.model.Result
@Dao
interface QuotableDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes() : List<Result>
}
