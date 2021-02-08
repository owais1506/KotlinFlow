package com.example.kotlinflow.ui.main.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
//import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.example.kotlinflow.R
import com.example.kotlinflow.ui.main.adapter.MainAdapter
import com.example.kotlinflow.ui.main.viewmodel.MainViewModel
import com.example.kotlinflow.utils.CallFragment


import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),CallFragment
{
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private var  fragment : Fragment? = null
    private lateinit var fragmentManager : FragmentManager

    companion object{
    }

    override fun onStart() {
        super.onStart()
        if (fragment == null){
            setUpFragment(MainFragment(),MainFragment.TAG)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        //setupUI()
        //setupViewModel()
        //setUpObserver()
    }


    override fun fragCall(fragment: Fragment, tag: String) {
        Log.e("You call me","I am here")
        setUpFragment(fragment,tag)
    }

    public  fun secondCall():FragmentManager
    {
        return supportFragmentManager
    }

    public fun setUpFragment(fragtoCall: Fragment,tag:String)
    {
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragtoCall, tag)
                .addToBackStack(tag)
                .commit()
    }

    /*private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
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
        mainViewModel.getEmployee().observe(this, Observer {
            when(it.status){
                Status.SUCCESS->{
                    progressBar.visibility = View.GONE
                    it?.data?.let { emp -> renderList(emp)  }
                    recyclerView.visibility = View.VISIBLE
                }

                Status.LOADING->{
                    progressBar.visibility= View.VISIBLE
                    recyclerView.visibility = View.GONE
                }

                Status.ERROR->{
                    progressBar.visibility= View.GONE
                    Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<Employee>) {
        Log.e("Users",users.toString())
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel(){
        mainViewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }*/
}