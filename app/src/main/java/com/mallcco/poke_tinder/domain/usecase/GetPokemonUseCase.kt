package com.mallcco.poke_tinder.domain.usecase

import com.mallcco.poke_tinder.data.PokemonRepository
import com.mallcco.poke_tinder.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke():List<Pokemon> {
        return repository.getAllPokemonFromApi()
    }
}