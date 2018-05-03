package com.carlos.carlos.csgoitems.data

import com.carlos.carlos.csgoitems.models.CSGOItems
import com.carlos.carlos.csgoitems.models.Item
import retrofit2.Call
import retrofit2.http.GET

interface CSGOApiInterface {

    companion object {
        const val BASE_URL = "http://api.csgo.steamlytics.xyz/v1/"
        const val API_KEY = "100af92cfc6e97c0d477a00417cd0cb4"
    }

    @GET("/v1/items?key=$API_KEY")
    fun getAllItems(): Call<CSGOItems<Item>>

}