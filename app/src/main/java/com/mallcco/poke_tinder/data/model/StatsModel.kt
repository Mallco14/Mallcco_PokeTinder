package com.mallcco.poke_tinder.data.model

import com.google.gson.annotations.SerializedName
import com.mallcco.poke_tinder.data.model.StatModel

data class StatsModel (
    @SerializedName("base_stat") val base_stat: Int,
    @SerializedName("stat") val stat: StatModel
)