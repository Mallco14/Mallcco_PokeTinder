package com.mallcco.poke_tinder.util

fun formatNumberTo3Digits(number: Int): String ="#${"%03d".format(number)}"
fun getIdPokemonFromUrl(url: String) : String = url.split("/").toTypedArray()[6]