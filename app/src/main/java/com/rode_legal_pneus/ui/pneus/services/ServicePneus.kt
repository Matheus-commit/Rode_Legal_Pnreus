package com.rode_legal_pneus.ui.pneus.services

import com.rode_legal_pneus.ui.pneus.models.Pneus
import retrofit2.Call
import retrofit2.http.GET

interface ServicePneus {

    @GET("pneus")
    fun getPneus(): Call<List<Pneus>>
}