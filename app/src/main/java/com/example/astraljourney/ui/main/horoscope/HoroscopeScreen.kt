package com.example.astraljourney.ui.main.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.astraljourney.databinding.FragmentHoroscopoScreenBinding
import com.example.astraljourney.databinding.FragmentLuckScreenBinding
import com.example.astraljourney.ui.main.luck.LuckViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeScreen : Fragment() {

    private var _binging: FragmentHoroscopoScreenBinding? = null
    private val binding get() = _binging!!

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binging = FragmentHoroscopoScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUiState()
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewModel.horoscopoUiState.collect {
                    binding.horoscopoRecyclerView.adapter = HoroscopoAdapter(it.zodiacSignItemsList)
                }
            }
        }
    }

}