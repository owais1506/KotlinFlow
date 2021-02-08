package com.example.kotlinflow.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinflow.data.api.ApiHelper
import com.example.kotlinflow.data.repository.MainRepo
import com.example.kotlinflow.ui.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepo(apiHelper)) as T
        }
            throw IllegalArgumentException("Unknown class name")

    }
}