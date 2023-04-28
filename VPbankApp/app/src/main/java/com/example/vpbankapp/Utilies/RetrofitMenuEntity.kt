package com.example.vpbankapp.Utilies

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitMenuEntity {

    private val client = OkHttpClient.Builder().build()

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://bachvanthe1994.github.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()
    }

    fun<T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}