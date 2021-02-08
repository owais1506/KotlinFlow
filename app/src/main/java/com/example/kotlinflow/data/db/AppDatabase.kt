package com.example.kotlinflow.data.db

import android.content.Context
import androidx.room.*
import com.example.kotlinflow.data.model.CustomConverter
import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerOrder

import com.example.kotlinflow.data.model.Music
import com.example.kotlinflow.utils.Converters

@Database(entities = arrayOf(CustomerOrder::class),version = 4,exportSchema = false)
@TypeConverters(CustomConverter::class)
public abstract class AppDatabase : RoomDatabase(){
    companion object{
        @Volatile private var mInstance : AppDatabase?=null

        fun getInstance(ctx: Context) : AppDatabase?=
            mInstance?: synchronized(this){
                mInstance ?: buildDatabase(ctx).also { mInstance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app.db").build()

            /*if(mInstance == null){
                mInstance = Room.databaseBuilder(ctx,AppDatabase::class.java,"Record")
                        .fallbackToDestructiveMigration()
                        .build()

            return mInstance
        }*/
    }

    abstract fun empRecord(): EmpDao?
}