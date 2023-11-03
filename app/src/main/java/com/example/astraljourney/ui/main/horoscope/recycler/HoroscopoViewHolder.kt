package com.example.astraljourney.ui.main.horoscope.recycler

import android.graphics.Interpolator
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.graphics.scaleMatrix
import androidx.recyclerview.widget.RecyclerView
import com.example.astraljourney.databinding.ZodiacItemListBinding
import com.example.astraljourney.domain.ZodiacSignInfo

class HoroscopoViewHolder(private val binding: ZodiacItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(zodiacSignInfo: ZodiacSignInfo, action: (zodiacSignInfo: ZodiacSignInfo) -> Unit) {
        zodiacSignInfo.apply {
            binding.ivZodiacItem.setImageResource(zodiacSignInfo.zodiacModel.image)
            binding.tvZodiacItem.text = binding.root.context.getString(name)
            binding.root.setOnClickListener {
                action(zodiacSignInfo)
//                startRotationAnim(binding.root, endAnimationListener = {
//
//                })
            }
        }
    }

    private fun startRotationAnim(view: View, endAnimationListener: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            scaleX(5.0f)
            scaleY(5.0f)
            alpha(0.0f)
        }.withEndAction { endAnimationListener() }.start()
    }
}