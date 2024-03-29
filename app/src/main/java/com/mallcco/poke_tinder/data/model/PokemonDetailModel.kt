package com.mallcco.poke_tinder.data.model

import com.google.gson.annotations.SerializedName
import com.mallcco.poke_tinder.domain.model.Abilities
import com.mallcco.poke_tinder.domain.model.PokemonDetail
import com.mallcco.poke_tinder.domain.model.Stats
import com.mallcco.poke_tinder.domain.model.Types

data class PokemonDetailModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("base_experience") val base_experience: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("stats") val stats: List<Stats>,
    @SerializedName("types") val types: List<Types>,
    @SerializedName("abilities") val abilities: List<Abilities>
    ) {
        fun ToDomain()= PokemonDetail (
        id = id,
        base_experience = base_experience,
        height = height,
        weight = weight,
        stats = stats,
        types = types,
        abilities = abilities
        )
}