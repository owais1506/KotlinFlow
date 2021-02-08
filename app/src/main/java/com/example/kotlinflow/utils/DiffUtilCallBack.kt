package com.example.kotlinflow.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.kotlinflow.data.model.CustomerBill

class DiffUtilCallBack : DiffUtil.ItemCallback<CustomerBill>(){
    override fun areItemsTheSame(oldItem: CustomerBill, newItem: CustomerBill): Boolean {
        return oldItem.customer_id == newItem.customer_id

    }

    override fun areContentsTheSame(oldItem: CustomerBill, newItem: CustomerBill): Boolean {
        return oldItem.invoiceNumber == newItem.invoiceNumber
                && oldItem.totalPaidAmt == newItem.totalPaidAmt
    }
}