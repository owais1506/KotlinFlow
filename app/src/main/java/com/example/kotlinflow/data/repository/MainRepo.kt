package com.example.kotlinflow.data.repository

import com.example.kotlinflow.data.api.ApiHelper
import com.example.kotlinflow.data.db.EmpDao
import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerOrder
import com.example.kotlinflow.data.model.Music
import io.reactivex.Single

class MainRepo(private val apiHelper: ApiHelper) {

    //var empDao : EmpDao?
    /*fun getUsers(): Single<List<Customer>>{
        return apiHelper.getUsers()
    }*/

    fun getUsers(): Single<List<CustomerOrder>>{
        return apiHelper.getUsers()
    }

    /*fun insertUser(customer: List<Customer>) : {
        empDao?.insert(customer)
    }*/

}