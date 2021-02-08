package com.example.kotlinflow.data.db

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerOrder
//import com.example.kotlinflow.data.db.AppDatabase.Companion.getInstance
//import com.example.kotlinflow.data.db.DatabaseClient.Companion.getInstance
//import com.example.kotlinflow.data.model.Employee
import com.example.kotlinflow.data.model.Music
import com.example.kotlinflow.utils.Resource
import com.example.kotlinflow.utils.Resources
import io.reactivex.Flowable
//import io.reactivex.annotations.NonNull
import kotlin.random.Random.Default.Companion


class RoomRxViewModel(app: Application) : AndroidViewModel(app) {

    var  appDatabase :AppDatabase = AppDatabase.getInstance(app)!!

    /*fun RoomRxViewModel1(@io.reactivex.annotations.NonNull app :Application ){
        //super.getApplication<Application>()
        //appDatabase = getInstance(app.applicationContext)!!
        appDatabase = Room.databaseBuilder(app.applicationContext,AppDatabase::class.java,"Record")
                .fallbackToDestructiveMigration()
                .build()
    }*/

    fun getList(): List<Music>? {
        return appDatabase.empRecord()?.getAllEmployee()
    }

    fun addData(employee: List<CustomerOrder>) {
         appDatabase.empRecord()?.insert(employee)
    }
}
