package com.mallcco.poke_tinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mallcco.poke_tinder.data.model.User
import com.mallcco.poke_tinder.util.SharedPreferenceUtil

class LoginViewModel(private val context: Context): ViewModel(){
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldsAuthenticateError = MutableLiveData<Boolean>()

    val goSuccesActivity = MutableLiveData<Boolean>()

    fun onCreate() {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(email:String, password: String) {
        if (email.isEmpty() && password. isEmpty()) {
            emptyFieldsError.postValue(true)
        }else {
            val user: User? = sharedPreferenceUtil.getUser()

            if (email.equals(user?.email) && password.equals(user?.password)) {
                goSuccesActivity.postValue(true)
            } else {
                fieldsAuthenticateError.postValue(true)
            }
        }
    }
}