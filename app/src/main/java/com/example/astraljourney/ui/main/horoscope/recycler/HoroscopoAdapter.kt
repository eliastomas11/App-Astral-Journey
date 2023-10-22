package com.example.astraljourney.ui.main.horoscope.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astraljourney.databinding.ZodiacItemListBinding
import com.example.astraljourney.domain.ZodiacSignInfo

class HoroscopoAdapter(
    private var zodiacSignInfoItemsList: List<ZodiacSignInfo> = emptyList(),
    private val action: (zodiacSignInfo: ZodiacSignInfo) -> Unit,
) : RecyclerView.Adapter<HoroscopoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        val binding = ZodiacItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HoroscopoViewHolder(binding)
    }

    override fun getItemCount(): Int = zodiacSignInfoItemsList.size

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.bind(zodiacSignInfoItemsList[position], action)
    }

    fun updateList(zodiacSignInfoList: List<ZodiacSignInfo>) {
        zodiacSignInfoItemsList = zodiacSignInfoList
        notifyDataSetChanged()
    }

}
