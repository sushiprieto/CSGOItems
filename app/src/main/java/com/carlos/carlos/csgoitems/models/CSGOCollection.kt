package com.carlos.carlos.csgoitems.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CSGOItems<T>(@SerializedName("items") val items: ArrayList<T> = ArrayList())

abstract class CSGOObject(@SerializedName("market_name") var market_name: String = "",
                            @SerializedName("image") var image: String = "",
                          @SerializedName("name_color") var name_color: String = "") : Serializable