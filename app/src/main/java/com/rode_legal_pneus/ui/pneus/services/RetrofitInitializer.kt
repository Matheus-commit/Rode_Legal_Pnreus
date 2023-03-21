package com.rode_legal_pneus.ui.pneus.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.net.URL


class RetrofitInitializer {

    val URL = "https://6418dc1875be53f451e85276.mockapi.io/api/v1/pneus"

    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServicePneus(): ServicePneus {
        return retrofit.create(ServicePneus::class.java)
    }
}