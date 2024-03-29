package com.mallcco.poke_tinder.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mallcco.poke_tinder.R

import com.mallcco.poke_tinder.domain.model.MyPokemon
import com.mallcco.poke_tinder.ui.holder.MyPokemonsHolder
import com.mallcco.poke_tinder.util.inflate


class MyPokemonsAdapter(val list: List<MyPokemon>) :
    RecyclerView.Adapter<MyPokemonsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = parent.inflate(R.layout.item_pokemon_saved)
        return MyPokemonsHolder(view)
    }

    override fun onBindViewHolder(holder: MyPokemonsHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }
     override fun getItemCount(): Int = list.size
}