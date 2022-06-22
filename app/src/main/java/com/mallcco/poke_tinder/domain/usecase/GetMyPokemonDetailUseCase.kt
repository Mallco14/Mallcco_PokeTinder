package com.mallcco.poke_tinder.domain.usecase

import com.mallcco.poke_tinder.data.PokemonRepository
import com.mallcco.poke_tinder.data.model.PokemonDetailModel
import javax.inject.Inject

class GetMyPokemonDetailUseCase @Inject constructor(private val repository: PokemonRepository) {

    suspend operator fun invoke(idPokemon: String): PokemonDetailModel {
        return repository.getPokemonDetailFromApi(idPokemon)
    }
}