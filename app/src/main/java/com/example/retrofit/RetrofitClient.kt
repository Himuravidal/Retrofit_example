package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{
        private const val URL_BASE = "https://recipe-puppy.p.rapidapi.com"
        private val retro = RetrofitClient

        fun getRetrofit(): ApiClient {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiClient::class.java)
        }
    }
}