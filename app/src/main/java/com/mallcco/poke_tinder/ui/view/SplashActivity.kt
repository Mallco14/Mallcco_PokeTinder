package com.mallcco.poke_tinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import com.mallcco.poke_tinder.databinding.ActivitySplashBinding
import com.mallcco.poke_tinder.ui.viewmodel.SplashViewModel
import com.mallcco.poke_tinder.util.SharedPreferenceUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        splashViewModel.getIsUnderMaintenance().observe(this) {
            if (it) {
                Toast.makeText(this, "Bajo Manteminimento", Toast.LENGTH_SHORT).show()
            } else {
                showAnimation()
            }
        }
    }

    fun showAnimation() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                //Evaluar si mostrar intro o no
                val isIntroAvailabe = sharedPreferenceUtil.getIntroShow()
                if (!isIntroAvailabe) {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                finish()
            },
            3000
        )
    }
}