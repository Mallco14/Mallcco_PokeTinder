package com.mallcco.poke_tinder.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mallcco.poke_tinder.R


import com.mallcco.poke_tinder.data.model.Onboarding
import com.mallcco.poke_tinder.databinding.ItemOnboardingBinding

import com.mallcco.poke_tinder.util.inflate


class OnboardingAdapter(val list: List<Onboarding>) :
    RecyclerView.Adapter<OnboardingAdapter.OnboardingHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingHolder {
            val view = parent.inflate(R.layout.item_onboarding)
            return OnboardingHolder(view)
        }

    override fun onBindViewHolder(holder: OnboardingHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

    class OnboardingHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemOnboardingBinding.bind(view)

        fun bind(onboarding: Onboarding) {
            with(binding) {

                hsv.setOnTouchListener { _, _ -> true }

                tvTitle.text = onboarding.title

                tvNameBackground.text = onboarding.namePokemon

                Glide
                    .with(itemView)
                    .load(onboarding.img)
                    .into(binding.ivPokemon)
            }
        }
    }
    }
