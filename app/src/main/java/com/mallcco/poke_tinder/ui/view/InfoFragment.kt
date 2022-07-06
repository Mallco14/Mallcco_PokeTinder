package com.mallcco.poke_tinder.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.mallcco.poke_tinder.databinding.FragmentInfoBinding

import com.mallcco.poke_tinder.ui.viewmodel.InfoViewModel

class InfoFragment(override val it: String) : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    private lateinit var viewModel: InfoViewModel

    private lateinit var webView: WebView

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val url = "https://pokemongolive.com/es/"

        webView = binding.wvMain

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = PokemonWebClient()

        viewModel.getUrlPokemon().observe(viewLifecycleOwner) {
            webView.loadUrl(it)
        }
    }

    inner class PokemonWebClient: WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            webView.loadUrl("javascript:(function() { " +
                    "document.getElementByClassName('navbar top')[0].style.display='none'; })()")
        }
    }
}