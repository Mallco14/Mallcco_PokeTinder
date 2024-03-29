package com.mallcco.poke_tinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mallcco.poke_tinder.data.network.FirebaseRemoteConfigRepository

class InfoViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }

    fun getIsUnderMaintenance():MutableLiveData<Boolean>{
        return firebaseRemoteConfigRepository.isUnderMaintenanceLiveData
    }

    fun getUrlPokemon(): MutableLiveData<String> {
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData

    }
}