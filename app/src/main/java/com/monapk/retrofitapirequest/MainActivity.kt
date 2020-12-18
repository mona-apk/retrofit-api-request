package com.monapk.retrofitapirequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.monapk.retrofitapirequest.network.request.GurunaviApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch(Dispatchers.IO) {
            val response = GurunaviApiService().getRestaurant()
            response?.run {
                this.rest.forEach {
                    Log.d("tag", it.toString())
                }
            }
        }
    }
}