package com.example.kotlinflow.utils

data class Resources<out T>(val status:Status,val data:T?,val message:String?)

class Resource {
    companion object{

        fun <T> success(data : T?) :Resources<T>{
            return Resources(Status.SUCCESS,data,null)
        }

        fun <T> error(msg : String?,data : T?) :Resources<T>{
            return Resources(Status.ERROR,data,msg)
        }

        fun <T> loading(data : T?) :Resources<T>{
            return Resources(Status.LOADING,data,null)
        }
    }
}