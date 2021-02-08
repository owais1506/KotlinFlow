package com.example.kotlinflow.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
import com.example.kotlinflow.R
import com.example.kotlinflow.data.model.Customer
import com.example.kotlinflow.data.model.CustomerBill
import com.example.kotlinflow.data.model.CustomerOrder
import com.example.kotlinflow.data.model.Music

import io.reactivex.Flowable
/*import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.data.model.User*/
import kotlinx.android.synthetic.main.item_layout.view.*


class MainAdapter(
    public val emp : ArrayList<CustomerBill>
    ) : RecyclerView.Adapter<MainAdapter.DataViewHolder1>() {

    class DataViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(emp: CustomerBill,pos:Int) {

            itemView.username.text = emp.invoiceNumber
            itemView.email.text = emp.totalPaidAmt.toString()
            /*Glide.with(itemView.imageViewAvatar.context)
                    .load(emp.avatar)
                    .into(itemView.imageViewAvatar)*/
            /*for (i in 0 until emp.data?.size!!) {
                itemView.username.text = emp.data?.get(i)?.CustomerName
                itemView.email.text = emp.data?.get(i)?.CustomerAge
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder1(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )


        )

    override fun getItemCount(): Int = emp.size

    override fun onBindViewHolder(holder: DataViewHolder1, position: Int) =
        holder.bind(emp[position],position)


    fun addData(list: List<CustomerBill>) {
        emp.addAll(list)
    }

    fun addFlowData(list: Flowable<List<Customer>>) {
    }

    /*override fun onBindViewHolder(holder: DataViewHolder1, position: Int) {
        TODO("Not yet implemented")
        holder.bind(emp[position],position)
    }*/

}