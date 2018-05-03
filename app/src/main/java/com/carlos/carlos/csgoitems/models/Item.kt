package com.carlos.carlos.csgoitems.models

import java.io.Serializable

class Item(market_name: String = "",
           image: String = "",
           name_color: String = "")
    : CSGOObject(market_name, image, name_color), Serializable