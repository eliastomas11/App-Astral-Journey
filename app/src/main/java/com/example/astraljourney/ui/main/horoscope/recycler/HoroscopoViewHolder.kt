package com.example.astraljourney.ui.main.horoscope.recycler

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.astraljourney.databinding.ZodiacItemListBinding
import com.example.astraljourney.domain.ZodiacSignInfo

class HoroscopoViewHolder(private val binding: ZodiacItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(zodiacSignInfo: ZodiacSignInfo, action: (zodiacSignInfo: ZodiacSignInfo) -> Unit) {
        zodiacSignInfo.apply {
            binding.ivZodiacItem.setImageResource(image)
            binding.tvZodiacItem.text = binding.root.context.getString(name)
            binding.root.setOnClickListener {
                startRotationAnim(binding.root, endAnimationListener = {
                    action(zodiacSignInfo)
                })
            }
        }
    }

    private fun startRotationAnim(view: View, endAnimationListener: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
        }.withEndAction { endAnimationListener() }.start()
    }
}