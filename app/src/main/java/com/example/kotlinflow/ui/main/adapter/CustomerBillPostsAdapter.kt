package com.example.kotlinflow.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinflow.R
import com.example.kotlinflow.data.model.CustomerBill
import com.example.kotlinflow.data.model.CustomerOrder
import com.example.kotlinflow.utils.DiffUtilCallBack
import kotlinx.android.synthetic.main.item_layout.view.*

class CustomerBillPostsAdapter : PagedListAdapter<CustomerBill,CustomerBillPostsAdapter.MyViewHolder>(
    DiffUtilCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent,
            false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.bindPost()
        getItem(position)?.let { order->
            holder.bindPost(order)
        }
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val username = itemView.username
        val email = itemView.email


        fun bindPost(redditPost : CustomerBill){
            with(redditPost){
                username.text = redditPost.invoiceNumber
                email.text = redditPost.totalPaidAmt.toString()
            }
        }
    }


}