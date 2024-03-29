package com.mallcco.poke_tinder.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mallcco.poke_tinder.data.database.entities.MyPokemonEntity


@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: MyPokemonEntity)

    @Query("SELECT * FROM pokemon_table")
    suspend fun getAllPokemons() : List<MyPokemonEntity>
}