package com.rode_legal_pneus.ui.pneus.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.net.URL


class RetrofitInitializer {

    val URL = "https://641a31c3f398d7d95d52933c.mockapi.io/api/v1/"

    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServicePneus(): ServicePneus {
        return retrofit.create(ServicePneus::class.java)
    }
}