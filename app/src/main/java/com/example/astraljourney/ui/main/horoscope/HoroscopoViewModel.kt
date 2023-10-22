package com.example.astraljourney.ui.main.horoscope

import androidx.lifecycle.ViewModel
import com.example.astraljourney.domain.GetZodiacSign
import com.example.astraljourney.domain.ZodiacSignInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(private val getZodiacSign: GetZodiacSign) : ViewModel() {

    private val _horoscopoUIState = MutableStateFlow<HoroscopoUiState>(HoroscopoUiState())
    val horoscopoUiState: StateFlow<HoroscopoUiState> = _horoscopoUIState

    init {
        _horoscopoUIState.value.apply {
            copy(zodiacSignInfoItemsList = getZodiacSign())
        }
    }
    data class HoroscopoUiState(
        val loading: Boolean = false,
        val zodiacSignInfoItemsList: List<ZodiacSignInfo> = emptyList(),
    )
}