package com.mallcco.poke_tinder.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mallcco.poke_tinder.data.database.dao.PokemonDao
import com.mallcco.poke_tinder.data.database.entities.MyPokemonEntity


@Database(entities = [MyPokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao
}