package com.mallcco.poke_tinder.domain.usecase


import com.mallcco.poke_tinder.domain.model.MyPokemon
import com.mallcco.poke_tinder.data.PokemonRepository
import com.mallcco.poke_tinder.data.database.entities.toDatabase


import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){

    suspend operator fun invoke(myPokemon: MyPokemon){
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }
}