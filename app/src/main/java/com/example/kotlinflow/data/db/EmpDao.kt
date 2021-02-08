package com.example.kotlinflow.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerOrder
//import com.example.kotlinflow.data.model.Employee
import com.example.kotlinflow.data.model.Music
import com.example.kotlinflow.utils.Resource
import com.example.kotlinflow.utils.Resources

//import io.reactivex.Flowable

@Dao
interface EmpDao {
    /*@Query("SELECT * FROM Customer")
    fun getAll(): Flowable<List<Customer?>>?*/

    @Query("SELECT * FROM CustomerOrder")
    fun getAllEmployee(): List<Music>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: List<CustomerOrder>)


}