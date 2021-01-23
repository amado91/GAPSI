package com.example.gapsi.service

import com.example.gapsi.service.`interface`.WebService
import com.example.v5baso.service.WSretrofit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var BASE_URL = "https://mighty-refuge-81707.herokuapp.com/api/auth/user/"
    var BASER_URL_CATALG = "https://mighty-refuge-81707.herokuapp.com/api/"
    var BASER_URL_CARD = "https://mighty-refuge-81707.herokuapp.com/api/catalogs/"
    var BASE_URL_NEW_CARD = "https://mighty-refuge-81707.herokuapp.com/api/"

    private val clientToken = OkHttpClient
        .Builder()
        .addNetworkInterceptor(WSretrofit())
        .build()

    private val client = OkHttpClient
        .Builder()
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(WebService::class.java)

    private val retrofitCatalog = Retrofit.Builder()
        .baseUrl(BASER_URL_CATALG)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientToken)
        .build()
        .create(WebService::class.java)

    private val retrofitCard = Retrofit.Builder()
        .baseUrl(BASER_URL_CARD)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientToken)
        .build()
        .create(WebService::class.java)

    private val retrofitCardNew = Retrofit.Builder()
        .baseUrl(BASE_URL_NEW_CARD)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientToken)
        .build()
        .create(WebService::class.java)

    fun buildService(): WebService {
        return retrofit
    }

    fun buildService2(): WebService {
        return retrofitCatalog
    }

    fun buildService3(): WebService {
        return retrofitCard
    }

    fun buildService4(): WebService {
        return retrofitCardNew
    }
}