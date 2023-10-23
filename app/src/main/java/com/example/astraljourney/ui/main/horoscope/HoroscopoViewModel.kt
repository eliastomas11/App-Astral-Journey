package com.example.astraljourney.ui.main.horoscope

import androidx.lifecycle.ViewModel
import com.example.astraljourney.domain.ZodiacSignInfo
import com.example.astraljourney.domain.usecases.HoroscopeUseCases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(private val getZodiacSign: GetZodiacList) : ViewModel() {

    private val _horoscopoUIState = MutableStateFlow<HoroscopoUiState>(HoroscopoUiState())
    val horoscopoUiState: StateFlow<HoroscopoUiState> get() =  _horoscopoUIState

    init {
        _horoscopoUIState.update {
            it.copy(loading = false, zodiacSignInfoItemsList = getZodiacSign())
        }
    }
    data class HoroscopoUiState(
        val loading: Boolean = true,
        val zodiacSignInfoItemsList: List<ZodiacSignInfo> = emptyList(),
    )
}