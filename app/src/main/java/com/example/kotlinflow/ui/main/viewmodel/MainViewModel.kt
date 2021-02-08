package com.example.kotlinflow.ui.main.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinflow.data.db.RoomRxViewModel
import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerOrder
//import com.example.kotlinflow.data.model.Employee
import com.example.kotlinflow.data.model.Music
import com.example.kotlinflow.data.repository.MainRepo
import com.example.kotlinflow.utils.Resource
import com.example.kotlinflow.utils.Resources
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepo: MainRepo) : ViewModel() {

    private val employee = MutableLiveData<Resources<List<CustomerOrder>>>()

    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {

        employee.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepo.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    employee.postValue(Resource.success(userList))
                }, { throwable ->
                    employee.postValue(Resource.error("Something went wrong",null))
                })
        )
    }
    public fun insertUser(app : Application?){
        val emp : List<CustomerOrder> = employee.value?.data!!
        val roomRxViewModel = RoomRxViewModel(app!!)
        roomRxViewModel.addData(emp)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getEmployee() : LiveData<Resources<List<CustomerOrder>>>{

        return employee
    }

    fun saveEmp()
    {

    }
}