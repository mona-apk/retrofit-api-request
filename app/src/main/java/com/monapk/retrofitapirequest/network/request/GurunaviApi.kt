package com.monapk.retrofitapirequest.network.request

import com.monapk.retrofitapirequest.network.model.Gurunavi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GurunaviApi {
    @GET("RestSearchAPI/v3")
    fun getRestaurant(@QueryMap params: Map<String, String>): Call<Gurunavi>
}