package com.mallcco.poke_tinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mallcco.poke_tinder.domain.model.MyPokemon
import com.mallcco.poke_tinder.domain.model.Pokemon
import com.mallcco.poke_tinder.domain.usecase.GetPokemonsUseCase
import com.mallcco.poke_tinder.domain.usecase.SaveMyPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val saveMyPokemonUseCase: SaveMyPokemonUseCase
): ViewModel() {
    val pokemonList = MutableLiveData<List<Pokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result=getPokemonsUseCase()
            pokemonList.postValue(result)
            isLoading.postValue(false)
        }
    }

    fun savePokemonUseCase(myPokemon: MyPokemon){
        viewModelScope.launch {
            isLoading.postValue(true)
            saveMyPokemonUseCase.invoke(myPokemon)
            isLoading.postValue(false)
        }
    }
}