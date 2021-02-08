package com.example.kotlinflow.data.api

import android.app.Application
import android.util.Log
import com.androidnetworking.utils.Utils
import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerOrder
//import com.example.kotlinflow.data.model.Employee
import com.example.kotlinflow.data.model.Music
import com.example.kotlinflow.ui.main.view.MainActivity
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single


class ApiServiceImpl : ApiService{
    /*override fun getUsers(): Single<List<Customer>> {
        return Rx2AndroidNetworking.get("https://5e510330f2c0d300147c034c.mockapi.io/users")
            .build()
            .getObjectListSingle(Customer::class.java)
    }*/

    override fun getUsers(): Single<List<CustomerOrder>> {
        return Rx2AndroidNetworking.get("https://kira.store/kira/ankita/Sync/")
                .build()
                .getObjectListSingle(CustomerOrder::class.java)
    }
}