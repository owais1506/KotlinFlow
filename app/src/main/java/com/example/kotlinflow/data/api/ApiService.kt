package com.example.kotlinflow.data.api

import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerOrder
//import com.example.kotlinflow.data.model.Employee
import com.example.kotlinflow.data.model.Music
import io.reactivex.Single

interface ApiService {
    //fun getUsers(): Single<List<Customer>>
    fun getUsers(): Single<List<CustomerOrder>>

}