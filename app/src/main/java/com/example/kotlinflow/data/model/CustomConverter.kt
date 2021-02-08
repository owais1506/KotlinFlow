package com.example.kotlinflow.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CustomConverter {


        @TypeConverter
        fun toInningValue(value: String?): List<CustomerBill?>? {
            if(value == null){
                return null
            }
            val gson = Gson()
            val listType: Type = object : TypeToken<List<CustomerBill?>?>() {}.type
            return gson.fromJson(value, listType)
        }

        @TypeConverter
        fun toJson(torrent: List<CustomerBill>?): String? {
            if(torrent == null){
                return null
            }
            val type = object: TypeToken<List<CustomerBill>>() {}.type
            return Gson().toJson(torrent, type)
        }


}