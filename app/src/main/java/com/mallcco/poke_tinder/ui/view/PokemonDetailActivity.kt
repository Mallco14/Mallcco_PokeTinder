package com.mallcco.poke_tinder.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.mallcco.poke_tinder.databinding.ActivityPokemonDetailBinding

import com.mallcco.poke_tinder.ui.viewmodel.PokemonsDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity : BaseActivity<ActivityPokemonDetailBinding>(ActivityPokemonDetailBinding::inflate){

    private val pokemonDetailViewModel: PokemonsDetailViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pokemonDetailViewModel.pokemonDetailModel.observe(this,{
            binding.txtname.text = it.name
            binding.txtid.text = it.id.toString()
            binding.txtexperience.text = it.base_experience.toString()
            binding.txtaltura.text = it.height.toString()
            binding.txtpeso.text = it.weight.toString()
            val image= "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${it.id}.png"
            Glide
                .with(this)
                .load(image)
                .into(binding.imageView4)
        })
        val pokemonId = intent?.extras?.getString("ID_POKEMON", null)

        if (pokemonId != null) {
            pokemonDetailViewModel.onCreate(pokemonId)
        }
        if (pokemonId != null){
            Toast.makeText(this, "PokemonId : $pokemonId", Toast.LENGTH_SHORT).show()
        }
    }
}