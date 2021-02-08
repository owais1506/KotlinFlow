package com.example.kotlinflow.data.network

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkCall : Application() {

    companion object{
         var  mInstance: NetworkCall ? =null
        lateinit var  retrofit: Retrofit

        @Synchronized
        fun getInstance() : NetworkCall? {
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        mInstance = this
//        if (!BuildConfig.DEBUG) {
//            final Fabric fabric = new Fabric.Builder(this)
//                    .kits(new Crashlytics())
//                    .build();
//            Fabric.with(fabric);
//        }

        //facebook stuff
        FacebookSdk.sdkInitialize(applicationContext)


    }


    @Synchronized
    fun getClient() : Retrofit{
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://cricket.yahoo.net/sifeeds/cricket/live/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.MINUTES)
                        .readTimeout(1, TimeUnit.MINUTES)
                        .retryOnConnectionFailure(true)
                        .addNetworkInterceptor(StethoInterceptor())
                        .build()
                )
                .build()
        }
        return retrofit

    }





}