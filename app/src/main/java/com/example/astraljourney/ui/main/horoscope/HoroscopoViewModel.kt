package com.example.astraljourney.ui.main.horoscope

import androidx.lifecycle.ViewModel
import com.example.astraljourney.domain.ZodiacSign
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class HoroscopoViewModel : ViewModel() {

    private val _zodiacSignItemList = MutableStateFlow<List<ZodiacSign>>(emptyList())
    val zodiacSignItemList: StateFlow<List<ZodiacSign>> = _zodiacSignItemList

    init {

    }
    data class HoroscopoUiState(
        val loading: Boolean = false,
        val zodiacSignItemsList: List<ZodiacSign> = emptyList(),

    )

}