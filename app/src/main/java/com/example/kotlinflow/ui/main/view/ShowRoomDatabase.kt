package com.example.kotlinflow.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinflow.R
import com.example.kotlinflow.data.db.RoomRxViewModel
import com.example.kotlinflow.ui.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.fragment_show_room_database.*

class ShowRoomDatabase : Fragment() {

    companion object{
        val TAG = "ShowRoomDatabase"
    }
    private lateinit var roomRxViewModel :RoomRxViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private lateinit var adapter: MainAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_room_database, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        roomRxViewModel = RoomRxViewModel(activity?.application!!)
        rvData.layoutManager = LinearLayoutManager(this.context)
        adapter = MainAdapter(arrayListOf())
        rvData.addItemDecoration(
            DividerItemDecoration(
                rvData.context,
                (rvData.layoutManager as LinearLayoutManager).orientation
            )
        )
        rvData.adapter = adapter
        roomRxViewModel.appDatabase.empRecord()?.getAllEmployee()?.let { adapter.addData(it) }
        roomRxViewModel.getList()?.let { adapter.addData(it) }
        adapter.notifyDataSetChanged()
    }

}