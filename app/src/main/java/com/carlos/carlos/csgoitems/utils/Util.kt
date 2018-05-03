package com.carlos.carlos.csgoitems.utils

import com.carlos.carlos.csgoitems.data.CSGOApiInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private var retrofit : Retrofit? = null

fun getRetrofit(): Retrofit {
    if (retrofit==null) {
        val client = OkHttpClient()
        val retrofit = Retrofit.Builder()
                .baseUrl(CSGOApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        return retrofit
    } else {
        return retrofit as Retrofit
    }
}