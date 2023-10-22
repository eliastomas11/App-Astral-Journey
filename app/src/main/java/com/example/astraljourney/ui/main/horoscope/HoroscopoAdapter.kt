package com.example.astraljourney.ui.main.horoscope

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astraljourney.databinding.ZodiacItemListBinding
import com.example.astraljourney.domain.ZodiacSign

class HoroscopoAdapter(
    private var zodiacSignItemsList: List<ZodiacSign> = emptyList(),
    private val action: (zodiacSign: ZodiacSign) -> Unit,
) : RecyclerView.Adapter<HoroscopoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        val binding = ZodiacItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HoroscopoViewHolder(binding)
    }

    override fun getItemCount(): Int = zodiacSignItemsList.size

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.bind(zodiacSignItemsList[position], action)
    }

    fun updateList(zodiacSignList: List<ZodiacSign>) {
        zodiacSignItemsList = zodiacSignList
        notifyDataSetChanged()
    }

}
