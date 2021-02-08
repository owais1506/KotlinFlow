package com.example.kotlinflow.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinflow.R
import com.example.kotlinflow.data.api.ApiHelper
import com.example.kotlinflow.data.api.ApiServiceImpl
import com.example.kotlinflow.data.db.RoomRxViewModel
import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerBill
import com.example.kotlinflow.data.model.CustomerOrder
//import com.example.kotlinflow.data.model.Employee
import com.example.kotlinflow.data.model.Music
import com.example.kotlinflow.ui.base.ViewModelFactory
import com.example.kotlinflow.ui.main.adapter.MainAdapter
import com.example.kotlinflow.ui.main.viewmodel.MainViewModel
import com.example.kotlinflow.utils.Status
import kotlinx.android.synthetic.main.fragment_show_live_data.*


class ShowLiveData : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var roomRxViewModel :RoomRxViewModel
    companion object{
        public val TAG = "ShowLiveData"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_live_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        roomRxViewModel = RoomRxViewModel(activity?.application!!)
        setupUI()
        setupViewModel()
        setUpObserver()

    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setUpObserver(){

        mainViewModel.getEmployee().observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS->{
                    progressBar.visibility = View.GONE
                    //roomRxViewModel.addData(it?.data)
                    it?.data?.let { emp -> renderList(emp.get(0).order)  }
                    recyclerView.visibility = View.VISIBLE

                }

                Status.LOADING->{
                    progressBar.visibility= View.VISIBLE
                    recyclerView.visibility = View.GONE
                }

                Status.ERROR->{
                    progressBar.visibility= View.GONE
                    Toast.makeText(this.context,it.message,Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    private fun renderList(users: List<CustomerBill>) {
        Log.e("Users",users.toString())
        adapter.addData(users)
        adapter.notifyDataSetChanged()
        mainViewModel.insertUser(activity?.application)
    }

    private fun setupViewModel(){
        mainViewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
        //mainViewModel = MainViewModel by ViewModel
    }

}