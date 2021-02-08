package com.example.kotlinflow.data.api

import com.example.kotlinflow.data.model.CustomerOrder
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface BillPaginates {

    @FormUrlEncoded
    @POST("pagination_all")
    fun getPaginates(@Field("store_id") id: String,@Field("first") first:String) : Response<CustomerOrder>

}