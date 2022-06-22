package com.mallcco.poke_tinder.ui.view

import android.os.Bundle
import android.widget.Toast
import com.mallcco.poke_tinder.R
import com.mallcco.poke_tinder.databinding.ActivityMyPokemonsBinding

import com.mallcco.poke_tinder.domain.model.MyPokemon
import com.mallcco.poke_tinder.ui.adapter.MyPokemonsAdapter


class MyPokemonsActivity : BaseActivity<ActivityMyPokemonsBinding>(ActivityMyPokemonsBinding::inflate){
        private var listPokemonSaved = mutableListOf<MyPokemon>()

        private val adapter = MyPokemonsAdapter(listPokemonSaved)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_pokemons)
        val pokemonId = intent?.extras?.getString("ID_POKEMON", null)

        if (pokemonId != null ) {
            Toast.makeText(this, "PokemonId: $pokemonId", Toast.LENGTH_SHORT).show()
        }
    }
}