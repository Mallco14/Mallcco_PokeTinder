package com.mallcco.poke_tinder.data

import com.mallcco.poke_tinder.data.database.dao.PokemonDao
import com.mallcco.poke_tinder.data.database.entities.MyPokemonEntity
import com.mallcco.poke_tinder.data.model.PokemonDetailModel
import com.mallcco.poke_tinder.data.model.PokemonListModel
import com.mallcco.poke_tinder.data.model.PokemonModel
import com.mallcco.poke_tinder.data.network.PokemonService
import com.mallcco.poke_tinder.domain.model.MyPokemon
import com.mallcco.poke_tinder.domain.model.Pokemon
import com.mallcco.poke_tinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon> {
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }
    //Realiza un llamado al API
    suspend fun getPokemonDetailFromApi(idPokemon: String): PokemonDetailModel {
        return pokemonService.getPokemonById(idPokemon)
    }
    //Realiza la consulta a la Base de Datos
    suspend fun getMyPokemonsFromDatabase(): List<MyPokemon> {
        val response: List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map { it.toDomain() }
    }

    suspend fun insertMyPokemon(myPokemon: MyPokemonEntity) {
        pokemonDao.insert(myPokemon)
    }
}