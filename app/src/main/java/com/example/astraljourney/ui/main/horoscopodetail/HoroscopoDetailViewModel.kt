package com.example.astraljourney.ui.main.horoscopodetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.astraljourney.domain.ZodiacModel
import com.example.astraljourney.domain.ZodiacSignInfo
import com.example.astraljourney.domain.usecases.HoroscopeUseCases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopoDetailViewModel @Inject constructor(private val getZodiacSignInfo: GetZodiacSignInfo) :
    ViewModel() {

    private val _detailUiState = MutableStateFlow<HoroscopoDetailUiState>(HoroscopoDetailUiState())
    val detailUiState get() = _detailUiState.asStateFlow()

    fun onInitialize(zodiacModel: ZodiacModel) {
        viewModelScope.launch {
            try {
                val result = getZodiacSignInfo(zodiacModel.name.lowercase())
                _detailUiState.update {
                    it.copy(
                        loading = false,
                        title = result.zodiacModel.name,
                        description = result.description,
                        date = result.date,
                        image = result.zodiacModel.anim
                    )
                }
            } catch (e: Exception) {
                _detailUiState.update {
                    it.copy(loading = false, error = e.message)
                }
            }
        }
    }

    data class HoroscopoDetailUiState(
        val loading: Boolean = true,
        val error: String? = null,
        val title: String = "",
        val date: String = "",
        val description: String = "",
        val image: Int = 0,
    )
}