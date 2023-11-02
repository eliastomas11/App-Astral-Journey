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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.astraljourney.databinding.FragmentHoroscopoScreenBinding
import com.example.astraljourney.ui.main.horoscope.recycler.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeScreen : Fragment() {

    private var _binging: FragmentHoroscopoScreenBinding? = null
    private val binding get() = _binging!!

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()

    private val horoscopoAdapter = HoroscopoAdapter(){ zodiac ->
        findNavController().navigate(HoroscopeScreenDirections.actionHoroscopeScreenToHoroscopoDetailActivity(type = zodiac.zodiacModel))
    }

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
        initRecycler()
        initUiState()
    }

    private fun initRecycler() {
        binding.horoscopoRecyclerView.apply {
            adapter = horoscopoAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
        binding.horoscopoRecyclerView.adapter = horoscopoAdapter
    }

    private fun initUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewModel.horoscopoUiState.collect {
                    horoscopoAdapter.updateList(it.zodiacSignInfoItemsList)
                }
            }
        }

    }



}