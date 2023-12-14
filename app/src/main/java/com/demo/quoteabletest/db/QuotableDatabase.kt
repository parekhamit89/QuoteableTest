package com.demo.quoteabletest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.quoteabletest.api.QuotableService
import com.demo.quoteabletest.model.Result

@Database(entities = [Result::class], version = 1)
abstract class QuotableDatabase :RoomDatabase(){
    abstract fun quotableDao() : QuotableDao

    companion object{
        @Volatile
        private var INSTANCE: QuotableDatabase? = null

        fun getDatabase(context: Context): QuotableDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        QuotableDatabase::class.java,
                        "quotableDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}