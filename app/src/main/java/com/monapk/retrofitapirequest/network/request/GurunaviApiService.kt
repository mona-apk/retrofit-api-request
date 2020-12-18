package com.monapk.retrofitapirequest.network.request

import android.util.Log
import com.monapk.retrofitapirequest.network.model.Gurunavi
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class GurunaviApiService {
    private val BASE_URL = "https://api.gnavi.co.jp/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(GurunaviApi::class.java)

    fun getRestaurant(): Gurunavi? {
        val queryParams: Map<String, String> = mapOf(
            "keyid" to "953daa6af0ca3e2f59b5a56210d9075f",
            "latitude" to "34.6974406",
            "longitude" to "135.4923925"
        )

        try {
            val response = api.getRestaurant(queryParams).execute()
            if (response.isSuccessful) {
                return response.body()
            } else {
                Log.d("tag", "GET ERROR")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}