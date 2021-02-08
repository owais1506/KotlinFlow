package com.example.kotlinflow.ui.main.view

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.kotlinflow.R
import com.example.kotlinflow.utils.CallFragment
import kotlinx.android.synthetic.main.fragment_main.*



class MainFragment : AppCompatDialogFragment() {

    var callFrag : CallFragment ? =null

    companion object{
        val TAG = "MainFragment"
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        callFrag = activity as? CallFragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cv_network.setOnClickListener{ v->callFragment()}
        cv_database.setOnClickListener() { v-> callFrag?.fragCall(ShowRoomDatabase(),ShowRoomDatabase.TAG) }
    }

    fun callFragment(){
        callFrag?.fragCall(ShowLiveData(), ShowLiveData.TAG)
    }
}