package com.mallcco.poke_tinder.data.model

import com.google.gson.annotations.SerializedName

data class StatModel(
    @SerializedName("name") val base_stat: Int,
    val name: String
)
