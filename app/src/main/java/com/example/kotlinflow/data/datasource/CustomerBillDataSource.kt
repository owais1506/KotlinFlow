package com.example.kotlinflow.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.kotlinflow.data.api.BillPaginates
import com.example.kotlinflow.data.model.CustomerOrder
import com.example.kotlinflow.data.network.NetworkCall
import com.example.kotlinflow.utils.Resource
import com.example.kotlinflow.utils.Status
import com.facebook.internal.Mutable
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Call
import java.lang.Exception

class CustomerOrderDataSource(private val scope: CoroutineScope):
    PageKeyedDataSource<Int, CustomerOrder>() {

    //var state: MutableLiveData<Status> = MutableLiveData()
    //var retryCompletable: Completable? = null
    private val billPaginates : BillPaginates = NetworkCall.getInstance()?.getClient()?.create(BillPaginates::class.java)!!

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CustomerOrder>) {

        scope.launch {

            try {

                val response = billPaginates.getPaginates("1192","1")

                when{
                    response.isSuccessful -> {
                        val listing: MutableList<CustomerOrder> =
                            response.body()?.order as MutableList<CustomerOrder>
                        //val invoice = listing?.map { it.invoiceNumber }
                        callback.onResult(listing, null, 2)
                    }
                }
            }
            catch (ex: Exception){
                Log.e("PostsDataSource", "Failed to fetch data!")
            }

        }


    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CustomerOrder>) {

        scope.launch {

            try {
                val response = billPaginates.getPaginates("1192","31")

                when{
                    response.isSuccessful -> {
                        val listing: MutableList<CustomerOrder> =
                            response.body()?.order as MutableList<CustomerOrder>
                        //val invoice = listing?.map { it.invoiceNumber }
                        callback.onResult(listing, params.key + 1)
                    }
                }
            }
            catch (ex: Exception){
                Log.e("PostsDataSource", "Failed to fetch data!")
            }

        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CustomerOrder>) {

    }

    override fun invalidate() {
        super.invalidate()
        scope.cancel(null)
    }

}

